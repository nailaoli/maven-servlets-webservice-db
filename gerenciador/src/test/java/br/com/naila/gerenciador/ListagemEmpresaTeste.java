package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.naila.gerenciador.database.ConnectionFactory;

public class ListagemEmpresaTeste {

    public static void main(String[] args) throws SQLException, PropertyVetoException {

	ConnectionFactory criaConexao = new ConnectionFactory();
	Connection conexao = criaConexao.getConnection();

	PreparedStatement stm = conexao.prepareStatement("SELECT id, nome, data FROM empresa;");
	stm.execute();

	ResultSet rst = stm.getResultSet();

	while (rst.next()) {
	    Integer id = rst.getInt("ID"); // column index or label
	    String nome = rst.getString("NOME");
	    String data = rst.getString("DATA");
	    System.out.printf("| %3d | %15s | %10s |%n", id, nome, data);
	}

	stm.close();
	conexao.close();

//	------------------ versão 2 - conexão através do Connection Factory

//	ConnectionFactory criaConexao = new ConnectionFactory();
//	Connection conexao = criaConexao.getConnection();
//
//	Statement stm = conexao.createStatement();
//	stm.execute("SELECT id, nome, data FROM empresa;");
//	ResultSet rst = stm.getResultSet();
//
//	while (rst.next()) {
//	    Integer id = rst.getInt("ID"); // column index or label
//	    String nome = rst.getString("NOME");
//	    String data = rst.getString("DATA");
//	    System.out.printf("| %3d | %15s | %10s |%n", id, nome, data);
//	}
//
//	stm.close();
//	rst.close();
//	conexao.close();

//	------------------ versão 1 - criando a conexão e executando o Statement

//	Connection connection = DriverManager.getConnection(
//		"jdbc:mysql://localhost:3306/empresas_db?useTimezone=true&serverTimezone=UTC", "root",
//		BancoSenha.getSenha());
//
//	Statement stm = connection.createStatement();
//	
////	boolean resultado = stm.execute("SELECT ID, NOME, DATA FROM EMPRESA;");
////	returns true if the first result is a ResultSetobject; false if it is an update count or there are no results
////	System.out.println(resultado); //output: true
//	
////	Para trabalhar com o resultado, teremos que recuperar o objeto ResultSet
//	stm.execute("SELECT ID, NOME, DATA FROM EMPRESA;");
//	ResultSet rst = stm.getResultSet();
//	
//	while(rst.next()) {
//	    Integer id = rst.getInt("ID"); // column index or label
//	    String nome = rst.getString("NOME");
//	    String data = rst.getString("DATA");
//	    System.out.printf("| %3d | %15s | %10s |%n", id, nome, data);
//	}
////		output: 
////        	|   1 |         LN Corp | 2015-10-10 |
////        	|   2 |       Ryan Corp | 1970-05-29 |
//	
//	rst.close();
//	stm.close();
//	connection.close();

    }

}
