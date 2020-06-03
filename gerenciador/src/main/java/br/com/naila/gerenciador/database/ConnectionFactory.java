package br.com.naila.gerenciador.database;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    private DataSource dataSource;
    private String password;

    public ConnectionFactory() throws PropertyVetoException {
	
//	--- 
	try (Scanner sc = new Scanner(new File("D:\\Documentos\\Projetos\\dbPassword.txt"))){
	    this.password = sc.next();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	if (this.password == null)
	    throw new NullPointerException("Não é possível conectar com o banco de dados");
//	/---

//	c3p0 - JDBC3 Connection and Statement Pooling
//	https://www.mchange.com/projects/c3p0/#using_combopooleddatasource
	ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
	comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/empresas_db?useTimezone=true&serverTimezone=UTC");
	comboPooledDataSource.setUser("root");
	comboPooledDataSource.setPassword(this.password);
	comboPooledDataSource.setMaxPoolSize(20);
//	https://stackoverflow.com/questions/38475936/c3p0-error-last-acquisition-attempt-exception-java-sql-sqlexception-no-sui
//	https://github.com/ROBINSINGH0210/SpringBootWithC3P0Pooling
//	comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
	comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
	this.dataSource = comboPooledDataSource;
    }

    public Connection getConnection() throws SQLException {
	return this.dataSource.getConnection();
    }
}

//	------ Antes de implementar o pool de conexões com o Datasource, inicializávamos uma nova conexão manualmente:
//	
//	public Connection getConnection() throws SQLException {
//	String path = "password.txt";
//
//	String password = null;
//
//	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//	    password = br.readLine();
//	} catch (FileNotFoundException e) {
//	    System.out.println(e.getMessage());
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
//
//	if (password == null)
//	    throw new NullPointerException("a senha do banco de dados não pode ser nula");
//
//	return DriverManager.getConnection(
//		"jdbc:mysql://localhost:3306/empresas_db?useTimezone=true&serverTimezone=UTC", "root", this.password);
//	}
//}
