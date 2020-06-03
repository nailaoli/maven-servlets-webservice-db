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

//    Repare que em nenhum lugar do projeto foi criado um método main(), ou foi instanciado
//    algum objeto servlet, nem os métodos doGet, doPost ou service foram chamados! Isso porque
//    quem faz tudo isso é o TomCat. O TomCat então é um servlet cointainer, um middleware. 
//    Ele é o intermediário que recebe a requisição http e repassa aos objetos servlet.
//    
//    O TomCat cria os objetos a partir do construtor, claro. Nada impede que a gente crie um
//    construtor, como no exemplo abaixo. Quando rodamos o servidor e chamamos o servlet via http
//    no navegador, a mensagem será executada no console, provante que o TomCat criou o objeto!

    public AdeusMundoServlet() {
	System.out.println("Criando o Servlet");
    }

//    O servlet só é criado ao se enviar a requisição http. Ou seja, não são criados todos os
//    servlets no momento em que rodamos nosso servidor. A criação é sob demanda, lazy. 
//    Porém, se ficarmos enviando várias requisições http, o TomCat cria apenas um objeto, 
//    não cria vários! Deixa o objeto em memória e reaproveita sempre o mesmo objeto.

//    O SERVLET ENTÃO É UM SINGLETON - Instância única dentro do container TomCat. Após criado
//    o objeto fica "para sempre" na memória. Só é apagado ao terminar o servidor.

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
