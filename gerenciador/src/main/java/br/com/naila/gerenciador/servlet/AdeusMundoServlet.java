package br.com.naila.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/oi")
public class AdeusMundoServlet extends HttpServlet {

//    Repare que em nenhum lugar do projeto foi criado um m�todo main(), ou foi instanciado
//    algum objeto servlet, nem os m�todos doGet, doPost ou service foram chamados! Isso porque
//    quem faz tudo isso � o TomCat. O TomCat ent�o � um servlet cointainer, um middleware. 
//    Ele � o intermedi�rio que recebe a requisi��o http e repassa aos objetos servlet.
//    
//    O TomCat cria os objetos a partir do construtor, claro. Nada impede que a gente crie um
//    construtor, como no exemplo abaixo. Quando rodamos o servidor e chamamos o servlet via http
//    no navegador, a mensagem ser� executada no console, provante que o TomCat criou o objeto!

    public AdeusMundoServlet() {
	System.out.println("Criando o Servlet");
    }

//    O servlet s� � criado ao se enviar a requisi��o http. Ou seja, n�o s�o criados todos os
//    servlets no momento em que rodamos nosso servidor. A cria��o � sob demanda, lazy. 
//    Por�m, se ficarmos enviando v�rias requisi��es http, o TomCat cria apenas um objeto, 
//    n�o cria v�rios! Deixa o objeto em mem�ria e reaproveita sempre o mesmo objeto.

//    O SERVLET ENT�O � UM SINGLETON - Inst�ncia �nica dentro do container TomCat. Ap�s criado
//    o objeto fica "para sempre" na mem�ria. S� � apagado ao terminar o servidor.

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	PrintWriter out = resp.getWriter();
	out.println("<html>");
	out.println("<body>");
	out.println("Hello world! Primeiro servlet");
	out.println("</body>");
	out.println("</html>");

	System.out.println("AdeusMundoServlet foi chamado");
    }

}
