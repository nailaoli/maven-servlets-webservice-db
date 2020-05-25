package br.com.naila.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.modelo.Banco;

public class ListaEmpresas implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("listando empresas");

	if (request.getParameter("novaEmpresa") != null) {
	    request.setAttribute("novaEmpresa", request.getParameter("novaEmpresa"));
	}

	request.setAttribute("empresas", Banco.getEmpresas());
	
	return "forward:listaEmpresas.jsp";
    }

}
