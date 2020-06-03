package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.EmpresaDao;
import br.com.naila.gerenciador.modelo.Empresa;

public class BuscaEmpresaPeloIdTeste {

    public static void main(String[] args) throws SQLException, PropertyVetoException {
	
	try(Connection conexao = new ConnectionFactory().getConnection()){
	    
	    EmpresaDao dao = new EmpresaDao(conexao);
	    
	    Empresa empresa = dao.buscaPeloId(2);
	    
	    System.out.println(empresa);
	    System.out.println(empresa.getCategoria());
	    
	}

    }

}
