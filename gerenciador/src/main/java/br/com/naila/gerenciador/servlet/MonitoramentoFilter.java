package br.com.naila.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Mapeando igual ao UnicaEntradaServlet, todas as requisi��es que chegarem ao servlet passar�o antes
//pelo filtro! Comentei a anota��o para fazer pelo web.xml, definindo a ordem de execu��o dos filtros.
//@WebFilter(urlPatterns="/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {

	System.out.println("Executando > MonitoramentoFilter");

	long antes = System.currentTimeMillis();

	String acao = request.getParameter("acao");

//	executa a a��o: continua a execu��o da requisi��o. sem isso a requisi��o para.
	chain.doFilter(request, response);

	long depois = System.currentTimeMillis();
	System.out.println("A��o: " + acao + " - tempo de execu��o -> " + (depois - antes));
    }

}
