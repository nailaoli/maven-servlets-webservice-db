package br.com.naila.gerenciador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexaoTeste {

    public static void main(String[] args) throws SQLException {

	Connection connection = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/empresas_db?useTimezone=true&serverTimezone=UTC", "root", "senha");

	System.out.println("Conexão ok! Fechando a Conexão.");

	connection.close();
    }

}
