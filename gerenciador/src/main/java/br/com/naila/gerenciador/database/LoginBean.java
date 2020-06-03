package br.com.naila.gerenciador.database;

import java.io.Serializable;

public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public LoginBean(String username, String password) {
	this.username = username;
	this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
