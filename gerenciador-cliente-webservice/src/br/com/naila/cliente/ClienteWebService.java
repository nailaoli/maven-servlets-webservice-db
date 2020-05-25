package br.com.naila.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

    public static void main(String[] args) throws ClientProtocolException, IOException {

	String conteudo = Request
		.Post("http://localhost:8080/gerenciador/empresas")
		.addHeader("Accept", "application/xml") // especificando qual o retorno o cliente deseja
		.execute()
		.returnContent()
		.asString(); // o conteúdo retornado do webservice virá como String

	System.out.println(conteudo);

//	output:
//        	 <java.util.Collections_-UnmodifiableCollection>
//        	  <c class="java.util.HashMap$Values">
//        	    <outer-class>
//        	      <entry>
//        	        <int>1</int>
//        	        <empresa>
//        	          <id>1</id>
//        	          <nome>Alura</nome>
//        	          <data>2020-05-16 17:18:23.561 UTC</data>
//        	        </empresa>
//        	      </entry>
//        	      <entry>
//        	        <int>2</int>
//        	        <empresa>
//        	          <id>2</id>
//        	          <nome>Caelum</nome>
//        	          <data>2020-05-16 17:18:23.561 UTC</data>
//        	        </empresa>
//        	      </entry>
//        	    </outer-class>
//        	  </c>
//        	</java.util.Collections_-UnmodifiableCollection>

	    
	    
    }

}
