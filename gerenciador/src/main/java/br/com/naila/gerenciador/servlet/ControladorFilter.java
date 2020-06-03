package br.com.naila.gerenciador.servlet;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
	    throws IOException, ServletException {

	System.out.println("Executando > ControladorFilter");

//	Fiz o cast para o elemento mais específico, pois possui mais métodos
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;

	String paramAcao = request.getParameter("acao");

	String nomeDaClasse = "br.com.naila.gerenciador.acao." + paramAcao;

	String retornoDoExecuta = null;

	try {
	    @SuppressWarnings("rawtypes")
	    Class classe = Class.forName(nomeDaClasse); // Reflection API
	    @SuppressWarnings("deprecation")
	    Acao acao = (Acao) classe.newInstance();
	    retornoDoExecuta = acao.executa(request, response);
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | PropertyVetoException e) {
	    throw new ServletException(e);
//	https://www.javaguides.net/2019/03/login-form-using-jsp-servlet-jdbc-mysql-example.html    
	} catch (SQLException e) {
	    for (Throwable ex : e) {
		if (e instanceof SQLException) {
		    e.printStackTrace(System.err);
		    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
		    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
		    System.err.println("Message: " + e.getMessage());
		    Throwable t = ex.getCause();
		    while (t != null) {
			System.out.println("Cause: " + t);
			t = t.getCause();
		    }
		}
	    }
	}

	String[] separa = retornoDoExecuta.split(":");
	String actionType = separa[0];
	String path = separa[1];

	switch (actionType) {
	case "forward":
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + path);
	    rd.forward(request, response);
	    break;
	case "redirect":
	    response.sendRedirect(path);
	    break;
	default:
	    throw new IllegalArgumentException("Parâmetro inválido ActionType): " + actionType);
	}

    }

}
