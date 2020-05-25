package br.com.naila.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.naila.gerenciador.modelo.Banco;
import br.com.naila.gerenciador.modelo.Usuario;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException {

	String login = request.getParameter("login");
	String senha = request.getParameter("senha");

	System.out.println("Logando " + login);
	
	Usuario usuario = Banco.autenticaUsuario(login, senha);
	
	if (usuario != null) {
	    System.out.println("Usuario existe");
	    HttpSession sessao = request.getSession();
	    sessao.setAttribute("usuarioLogado", usuario);
	    return "redirect:entrada?acao=ListaEmpresas";
	} else {
	    System.out.println("Usuario não existe");
	    return "redirect:entrada?acao=LoginForm";
	}
    }

}
