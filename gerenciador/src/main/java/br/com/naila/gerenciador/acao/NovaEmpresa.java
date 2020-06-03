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

public class NovaEmpresa implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException, PropertyVetoException {
	System.out.println("Cadastrando nova empresa");

	String nome = request.getParameter("nome");
	
	try(Connection conexao = new ConnectionFactory().getConnection()){
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    new EmpresaDao(conexao)
	    		.adiciona(new Empresa(
        	    			nome,
        	    			LocalDate.parse(request.getParameter("data"), formatter),
        	    			new Categoria(Integer.valueOf(request.getParameter("categoria")))
	    			));	    
	}

	return "redirect:entrada?acao=ListaEmpresas&novaEmpresa=" + nome;
	
    }

}
