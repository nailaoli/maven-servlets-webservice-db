package br.com.naila.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.naila.gerenciador.modelo.Banco;
import br.com.naila.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class ListaEmpresasService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String valor = request.getHeader("Accept"); // cliente envia header especificando se quer json ou xml

	if (valor.contains("application/json")) {
//	    Passando a lista de empresas para a biblioteca Gson gerar um JSON
	    Gson gson = new Gson();
	    String json = gson.toJson(Banco.getEmpresas());
//	    Boa prátia: definir o que a resposta devolve
	    response.setContentType("application/json");
	    response.getWriter().print(json);
	} else if (valor.contains("application/xml")) {
//	    O mesmo que o JSON, só que transformando em XML com a biblioteca XStream
	    XStream xstream = new XStream();
//	    Se quisermos evitar que o xml escreva o fqn da classe Empresa
	    xstream.alias("empresa", Empresa.class);
	    String xml = xstream.toXML(Banco.getEmpresas());
	    response.setContentType("application/xml");
	    response.getWriter().print(xml);
	} else {
	    response.setContentType("application/json");
	    response.getWriter().print("{'message':'no content'}"); 
	    
	}
    }
}
