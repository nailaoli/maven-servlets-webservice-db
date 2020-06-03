package br.com.naila.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Comentei a anotação para fazer pelo web.xml, definindo a ordem de execução dos filtros.
//@WebFilter(urlPatterns="/entrada")
public class AutorizacaoFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
	    throws IOException, ServletException {
	
	
	System.out.println("Executando > AutorizacaoFilter");
	
//	Fiz o cast para o elemento mais específico, pois possui mais métodos
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;
	
	String paramAcao = request.getParameter("acao");
	
	boolean ehAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//	Verifica se o usuário está logado
	boolean usuarioEstaLogado = request.getSession().getAttribute("usuarioLogado") != null;
	if (ehAcaoProtegida && !usuarioEstaLogado) {
	    response.sendRedirect("entrada?acao=LoginForm");
	    return; 
	}
	
//	Devemos fazer a verificação de segurança antes de mandar a requisição para frente
	chain.doFilter(request, response);
    }

}
