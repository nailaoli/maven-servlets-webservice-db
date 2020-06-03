package br.com.naila.gerenciador.acao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.EmpresaDao;

public class ListaEmpresas implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException, SQLException, PropertyVetoException {
	System.out.println("listando empresas");
	
//	Mensagem de empresa criada com sucesso
	if (request.getParameter("novaEmpresa") != null) {
	    request.setAttribute("novaEmpresa", request.getParameter("novaEmpresa"));
	}
	
	try (Connection conexao = new ConnectionFactory().getConnection()) {
	  request.setAttribute("empresas", new EmpresaDao(conexao).lista());  
	}
	
	return "forward:listaEmpresas.jsp";
    }
}
