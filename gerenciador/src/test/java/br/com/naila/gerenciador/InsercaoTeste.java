package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.naila.gerenciador.database.ConnectionFactory;

public class InsercaoTeste {

    public static void main(String[] args) throws SQLException, PropertyVetoException {

	ConnectionFactory factory = new ConnectionFactory();
	Connection conexao = factory.getConnection();

//	Sem o PreparedStatement!
	
	Statement stm = conexao.createStatement();

	stm.execute("INSERT INTO empresa (nome, data) VALUES ('Tio Patinhas Corp', '1950-06-25')",
		Statement.RETURN_GENERATED_KEYS);

	ResultSet rst = stm.getGeneratedKeys();

	while (rst.next()) {
	    Integer id = rst.getInt(1); // column index. no sql, a primeira coluna é 1
	    System.out.println("O id criado foi: " + id);
	}
	
	conexao.close();
    }

}
