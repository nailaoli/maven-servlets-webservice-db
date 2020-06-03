package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.naila.gerenciador.database.ConnectionFactory;

public class RemocaoTeste {

    public static void main(String[] args) throws SQLException, PropertyVetoException {

	
	ConnectionFactory factory = new ConnectionFactory();
	Connection conexao = factory.getConnection();
	
	PreparedStatement stm = conexao.prepareStatement("DELETE FROM empresa WHERE id > ?");
	stm.setInt(1, 2);
	stm.execute();
	System.out.println("Linhas modificadas: " + stm.getUpdateCount());
	
	conexao.close();
	
	
////	------------------ versão 1 - sem o PreparedStatement
//	
//	ConnectionFactory factory = new ConnectionFactory();
//	Connection conexao = factory.getConnection();
//
//	Statement stm = conexao.createStatement();
//	stm.execute("DELETE FROM empresa WHERE id > 2");
//
//	System.out.println("Linhas modificadas: " + stm.getUpdateCount());

    }

}
