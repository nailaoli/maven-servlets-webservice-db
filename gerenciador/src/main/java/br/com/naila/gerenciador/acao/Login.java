package br.com.naila.gerenciador.acao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.LoginBean;
import br.com.naila.gerenciador.database.dao.LoginDao;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException, PropertyVetoException, SQLException {

	String login = request.getParameter("login");
	String senha = request.getParameter("senha");
	
	LoginBean loginBean = new LoginBean(login, senha); 
	
	boolean logado = false;
	
	try(Connection conexao = new ConnectionFactory().getConnection()){
	    logado = new LoginDao(conexao).valida(loginBean);
	}

	System.out.println("Logando " + login);

	if (logado) {
	    System.out.println("Usuario existe");
	    HttpSession sessao = request.getSession();
	    sessao.setAttribute("usuarioLogado", loginBean);
	    return "redirect:entrada?acao=ListaEmpresas";
	} else {
	    System.out.println("Usuario não existe");
	    return "redirect:entrada?acao=LoginForm";
	}
    }

}
