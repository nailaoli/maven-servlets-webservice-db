package br.com.naila.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {

	HttpSession session = request.getSession();
//	session.removeAttribute("usuarioLogado");
	
	session.invalidate(); // remove o objeto HttpSession e todos os objetos associados a ele, ao mesmo
			      // tempo em que destrói o cookie
	return "redirect:entrada?acao=LoginForm";
    }

}
