package br.com.naila.gerenciador.acao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.EmpresaDao;

public class RemoveEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, PropertyVetoException {
	
	System.out.println("removendo empresa");

	try(Connection conexao = new ConnectionFactory().getConnection()){
	    Integer id = Integer.valueOf(request.getParameter("id"));
	    new EmpresaDao(conexao).removeEmpresa(id);	    
	}

	return "redirect:entrada?acao=ListaEmpresas";
    }
}