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

public class NovaEmpresaForm implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, PropertyVetoException {

	try (Connection conexao = new ConnectionFactory().getConnection()) {
	    request.setAttribute("categorias", new CategoriaDao(conexao).listaCategorias());
	}
	
	return "forward:formNovaEmpresa.jsp";
    }

}
