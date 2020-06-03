package br.com.naila.gerenciador.acao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.EmpresaDao;
import br.com.naila.gerenciador.modelo.Empresa;

public class ListaEmpresasOrdemAlfabetica implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException, SQLException, PropertyVetoException {

	System.out.println("listando empresas em ordem alfabética");

	try (Connection conexao = new ConnectionFactory().getConnection()){
		List<Empresa> lista = new ArrayList<Empresa>(new EmpresaDao(conexao).lista());
		lista.sort((e1, e2) -> (e1.getNome().toUpperCase().compareTo(e2.getNome().toUpperCase())));
		request.setAttribute("empresas", lista);
	}

	return "forward:listaEmpresas.jsp";
    }

}
