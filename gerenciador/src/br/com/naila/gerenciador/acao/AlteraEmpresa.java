package br.com.naila.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.modelo.Banco;

public class AlteraEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

	System.out.println("alterando empresa");
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Date data;

	try {
	    data = sdf.parse(request.getParameter("data"));
	} catch (ParseException e) {
	    throw new ServletException(e);
	}

	Banco.alteraEmpresa(Integer.valueOf(request.getParameter("id")), request.getParameter("nome"), data);

	return "redirect:entrada?acao=ListaEmpresas";
	
    }

}
