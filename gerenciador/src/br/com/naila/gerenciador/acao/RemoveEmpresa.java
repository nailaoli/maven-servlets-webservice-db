package br.com.naila.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	System.out.println("removendo empresa");

	Banco.removeEmpresa(Integer.valueOf(request.getParameter("id")));

	return "redirect:entrada?acao=ListaEmpresas";
    }
}