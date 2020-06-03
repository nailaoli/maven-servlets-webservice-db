package br.com.naila.gerenciador.acao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.CategoriaDao;
import br.com.naila.gerenciador.database.dao.EmpresaDao;
import br.com.naila.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException, SQLException, PropertyVetoException {

	System.out.println("mostrando dados da empresa");

	try (Connection conexao = new ConnectionFactory().getConnection()) {
	    Empresa empresa = new EmpresaDao(conexao).buscaPeloId(Integer.valueOf(request.getParameter("id")));
	    request.setAttribute("nome", empresa.getNome());
	    request.setAttribute("data", empresa.getData());
	    request.setAttribute("id", empresa.getId());
	    request.setAttribute("categoriaId", empresa.getCategoria().getId());
	    request.setAttribute("categorias", new CategoriaDao(conexao).listaCategorias());
	}
	return "forward:formAlteraEmpresa.jsp";
    }

}
