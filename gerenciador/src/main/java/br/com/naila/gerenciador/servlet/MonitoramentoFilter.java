package br.com.naila.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Mapeando igual ao UnicaEntradaServlet, todas as requisições que chegarem ao servlet passarão antes
//pelo filtro! Comentei a anotação para fazer pelo web.xml, definindo a ordem de execução dos filtros.
//@WebFilter(urlPatterns="/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {

	System.out.println("Executando > MonitoramentoFilter");

	long antes = System.currentTimeMillis();

	String acao = request.getParameter("acao");

//	executa a ação: continua a execução da requisição. sem isso a requisição para.
	chain.doFilter(request, response);

	long depois = System.currentTimeMillis();
	System.out.println("Ação: " + acao + " - tempo de execução -> " + (depois - antes));
    }

}
