package br.com.naila.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.modelo.Banco;
import br.com.naila.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	System.out.println("Cadastrando nova empresa");

	String nome = request.getParameter("nome");
	
	Empresa empresa = new Empresa(nome);

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	Date data;

	try {
	    data = sdf.parse(request.getParameter("data"));
	} catch (ParseException e) {
	    throw new ServletException(e);
	}

	empresa.setData(data);

	Banco.adiciona(empresa);

	return "redirect:entrada?acao=ListaEmpresas&novaEmpresa=" + nome;
	
    }

}
