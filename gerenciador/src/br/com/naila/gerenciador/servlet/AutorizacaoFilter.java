package br.com.naila.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Comentei a anota��o para fazer pelo web.xml, definindo a ordem de execu��o dos filtros.
//@WebFilter(urlPatterns="/entrada")
public class AutorizacaoFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
	    throws IOException, ServletException {
	
	
	System.out.println("Executando > AutorizacaoFilter");
	
//	Fiz o cast para o elemento mais espec�fico, pois possui mais m�todos
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;
	
	String paramAcao = request.getParameter("acao");
	
	boolean ehAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//	Verifica se o usu�rio est� logado
	boolean usuarioEstaLogado = request.getSession().getAttribute("usuarioLogado") != null;
	if (ehAcaoProtegida && !usuarioEstaLogado) {
	    response.sendRedirect("entrada?acao=LoginForm");
	    return; 
	}
	
//	Devemos fazer a verifica��o de seguran�a antes de mandar a requisi��o para frente
	chain.doFilter(request, response);
    }

}
