package br.com.naila.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.naila.gerenciador.modelo.Banco;

public class MostraEmpresa implements Acao {

    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("mostrando dados da empresa");
	
	Integer id = Integer.valueOf(request.getParameter("id"));
	request.setAttribute("nome", Banco.buscaEmpresaPeloId(id).getNome());
	request.setAttribute("data", Banco.buscaEmpresaPeloId(id).getData());
	request.setAttribute("id", id);
	
	return "forward:formAlteraEmpresa.jsp";

    }

}
