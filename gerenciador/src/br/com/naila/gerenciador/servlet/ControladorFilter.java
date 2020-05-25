package br.com.naila.gerenciador.servlet;

import java.io.IOException;

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

	String retornoDoExecuta;

	try {
	    @SuppressWarnings("rawtypes")
	    Class classe = Class.forName(nomeDaClasse); // Reflection API
	    @SuppressWarnings("deprecation")
	    Acao acao = (Acao) classe.newInstance();
	    retornoDoExecuta = acao.executa(request, response);
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	    throw new ServletException(e);
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
