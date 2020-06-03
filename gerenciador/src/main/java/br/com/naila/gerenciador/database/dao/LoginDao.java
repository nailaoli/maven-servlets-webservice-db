package br.com.naila.gerenciador.database.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.naila.gerenciador.database.LoginBean;

public class LoginDao {
   
    private Connection conexao;
    
    public LoginDao(Connection conexao) {
	this.conexao = conexao;
    }
    
    public boolean valida(LoginBean loginBean) throws PropertyVetoException, SQLException {
	boolean status = false;
	
	String sql = "SELECT * FROM login WHERE username = ? AND password = ?;";

	try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {

	    preparedStatement.setString(1, loginBean.getUsername());
	    preparedStatement.setString(2, loginBean.getPassword());

	    System.out.println(preparedStatement);
	    System.out.println("Query: login");
	    ResultSet rs = preparedStatement.executeQuery();
	    status = rs.next();
	    
	}

	return status;
    }

}