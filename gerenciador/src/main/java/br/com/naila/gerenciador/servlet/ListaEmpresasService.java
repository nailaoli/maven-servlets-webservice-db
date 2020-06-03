package br.com.naila.gerenciador.servlet;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.EmpresaDao;
import br.com.naila.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class ListaEmpresasService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	try {

	    String valor = request.getHeader("Accept"); // cliente envia header especificando se quer json ou xml

	    if (valor.contains("application/json")) {
//		Passando a lista de empresas para a biblioteca Gson gerar um JSON
		Gson gson = new Gson();
		Connection conexao = new ConnectionFactory().getConnection();
		String json = gson.toJson(new EmpresaDao(conexao).lista());
		conexao.close();
//	    	Boa prátia: definir o que a resposta devolve
		response.setContentType("application/json");
		response.getWriter().print(json);
	    } else if (valor.contains("application/xml")) {
//	    	O mesmo que o JSON, só que transformando em XML com a biblioteca XStream
		XStream xstream = new XStream();
//	    	Se quisermos evitar que o xml escreva o fqn da classe Empresa
		xstream.alias("empresa", Empresa.class);
		Connection conexao = new ConnectionFactory().getConnection();
		String xml = xstream.toXML(new EmpresaDao(conexao).lista());
		conexao.close();
		response.setContentType("application/xml");
		response.getWriter().print(xml);
	    } else {
		response.setContentType("application/json");
		response.getWriter().print("{'message':'no content'}");
	    }
	    
	} catch (SQLException e) {
	    for (Throwable ex : e) {
		if (e instanceof SQLException) {
		    e.printStackTrace(System.err);
		    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
		    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
		    System.err.println("Message: " + e.getMessage());
		    Throwable t = ex.getCause();
		    while (t != null) {
			System.out.println("Cause: " + t);
			t = t.getCause();
		    }
		}
	    }
	} catch (PropertyVetoException e) {
	    e.printStackTrace();
	}
    }
}
