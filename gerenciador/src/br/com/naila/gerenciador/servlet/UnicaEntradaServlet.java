package br.com.naila.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// No final essa classe foi toda comentada porque suas funções foram transformadas em filtros, melhorando o código!

@SuppressWarnings("serial")
//@WebServlet(urlPatterns="/entrada")
public class UnicaEntradaServlet extends HttpServlet {

//    interface HttpServletRequest estende a interface ServletRequest
    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

//	String paramAcao = request.getParameter("acao");

//	Verifica se a ação é protegida, se precisa estar logado para acessa-la. As únicas que são desprotegidas são
//	as necessárias para login
//	boolean ehAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
////	Verifica se o usuário está logado
//	boolean usuarioEstaLogado = request.getSession().getAttribute("usuarioLogado") != null;
//	if (ehAcaoProtegida && !usuarioEstaLogado) {
//	    response.sendRedirect("entrada?acao=LoginForm");
//	    return; // Interrompe a execução do método. Sem esse return o método continuaria
//		    // executando e daria erro pois não dá para devolver outra resposta, a resposta
//		    // já foi enviada.
//	}

	
//	String nomeDaClasse = "br.com.naila.gerenciador.acao." + paramAcao;
//
//	String retornoDoExecuta;
//
//	try {
//	    @SuppressWarnings("rawtypes")
//	    Class classe = Class.forName(nomeDaClasse); // Reflection API
//	    @SuppressWarnings("deprecation")
//	    Acao acao = (Acao) classe.newInstance();
//	    retornoDoExecuta = acao.executa(request, response);
//	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//	    throw new ServletException(e);
//	}
//
//	String[] separa = retornoDoExecuta.split(":");
//	String actionType = separa[0];
//	String path = separa[1];
//
//	switch (actionType) {
//	case "forward":
//	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + path);
//	    rd.forward(request, response);
//	    break;
//	case "redirect":
//	    response.sendRedirect(path);
//	    break;
//	default:
//	    throw new IllegalArgumentException("Parâmetro inválido ActionType): " + actionType);
//	}

//	//Reflection API substituiu o código abaixo
//	switch (paramAcao) {
//	case "ListaEmpresas":
//	    retornoDoExecuta = new ListaEmpresas().executa(request, response);
//	    break;
//	case "RemoveEmpresa":
//	    retornoDoExecuta = new RemoveEmpresa().executa(request, response);
//	    break;
//	case "AlteraEmpresa":
//	    retornoDoExecuta = new AlteraEmpresa().executa(request, response);
//	    break;
//	case "MostraEmpresa":
//	    retornoDoExecuta = new MostraEmpresa().executa(request, response);
//	    break;
//	case "NovaEmpresa":
//	    retornoDoExecuta = new NovaEmpresa().executa(request, response);
//	    break;
//	case "NovaEmpresaForm":
//	    retornoDoExecuta = new NovaEmpresaForm().executa(request, response);
//	    break;
//	default:
//	    throw new IllegalArgumentException("Parâmetro inválido (Acao): " + paramAcao);
//	}

    }
}
