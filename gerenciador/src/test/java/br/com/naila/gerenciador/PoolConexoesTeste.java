package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import br.com.naila.gerenciador.database.ConnectionFactory;

public class PoolConexoesTeste {

    public static void main(String[] args) throws SQLException, PropertyVetoException {
	
	ConnectionFactory connectionFactory = new ConnectionFactory();
	
	for (int i = 1; i <= 20; i++) {
	    connectionFactory.getConnection();
	    System.out.println("Conexao de Numero: " + i);
	}

    }

}
