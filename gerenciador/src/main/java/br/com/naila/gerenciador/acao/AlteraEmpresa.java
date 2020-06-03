package br.com.naila.gerenciador.acao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.EmpresaDao;
import br.com.naila.gerenciador.modelo.Categoria;
import br.com.naila.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException, SQLException, PropertyVetoException {

	System.out.println("alterando empresa");
	
	try(Connection conexao = new ConnectionFactory().getConnection()){
	   
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate data = LocalDate.parse(request.getParameter("data"), formatter);
	   
	    new EmpresaDao(conexao)
	    		.altera(new Empresa(
	    				Integer.valueOf(request.getParameter("id")),
	    				request.getParameter("nome"),
	    				data,
	    				new Categoria(Integer.valueOf(request.getParameter("categoria")))
	    			));
	}
	
	return "redirect:entrada?acao=ListaEmpresas";
	
    }

}
