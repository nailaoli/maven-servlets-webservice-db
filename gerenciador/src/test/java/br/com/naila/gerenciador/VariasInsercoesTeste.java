package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.naila.gerenciador.database.ConnectionFactory;

public class VariasInsercoesTeste {

    public static void main(String[] args) throws SQLException, PropertyVetoException {

	ConnectionFactory factory = new ConnectionFactory();

	try (Connection conexao = factory.getConnection()) {

	    conexao.setAutoCommit(false);

	    try (PreparedStatement stm = conexao.prepareStatement("INSERT INTO empresa (nome, data) VALUES (?, ?)",
		    Statement.RETURN_GENERATED_KEYS)) {
		String nome = "Dunder Mifflin";
		String data = "1960-07-20";

		adicionarVariavel(nome, data, stm);
		adicionarVariavel("Maille", "1747-11-15", stm);

		conexao.commit(); // quando todos as execuções estiverem ok, aí sim será dado commit na transação.
		// ou se faz todo o procedimento ou não se faz nada
	    } catch (Exception e) {
		e.printStackTrace();
		conexao.rollback();
		System.out.println("ROLLBACK EXECUTADO");
	    }
	}
    }

    private static void adicionarVariavel(String nome, String data, PreparedStatement stm) throws SQLException {

//	if (nome == "Maille")
//	    throw new RuntimeException("Erro");

	stm.setString(1, nome);
	stm.setString(2, data);
	stm.execute();

	try (ResultSet rst = stm.getGeneratedKeys()) {
	    while (rst.next()) {
		Integer id = rst.getInt(1);
		System.out.println("O id criado foi: " + id);
	    }
	}
    }
}
