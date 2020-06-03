package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.naila.gerenciador.database.ConnectionFactory;

public class InsercaoComParametroTeste {

    public static void main(String[] args) throws SQLException, PropertyVetoException {

	String nome = "Dunder Mifflin); delete from Empresa;"; //ops..!
	String data = "1960-07-20";
	
	ConnectionFactory factory = new ConnectionFactory();
	Connection conexao = factory.getConnection();
	
////	Assim possibilitava um SQL INJECTION. O que fosse passado dentro do String pode ser interpretado como 
////	comando SQL
//	Statement stm = conexao.createStatement();
//	stm.execute("INSERT INTO empresa (nome, data) VALUES ('" + nome + "', '" + data + "')",
//		Statement.RETURN_GENERATED_KEYS);
	
//	Preparamos o Statement e depois executamos. Assim evitaremos problemas como erros na sintaxe dos comandos
//	SQL e SQL INJECTION
	PreparedStatement stm = conexao.prepareStatement("INSERT INTO empresa (nome, data) VALUES (?, ?)",
		Statement.RETURN_GENERATED_KEYS);
	stm.setString(1, nome); //ordem do parâmetro e parâmetro
	stm.setString(2, data);
	stm.execute();
//	No caso será inserido na base de dados um registro com o nome "Dunder Mifflin); delete from Empresa;"
//	Ou seja, foi tratado como String e não executados como comando SQL
	
	ResultSet rst = stm.getGeneratedKeys();
	

	while (rst.next()) {
	    Integer id = rst.getInt(1); // column index. no sql, a primeira coluna é 1
	    System.out.println("O id criado foi: " + id);    
	}
	
	conexao.close();

    }

}
