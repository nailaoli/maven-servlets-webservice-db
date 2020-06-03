package br.com.naila.gerenciador;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.naila.gerenciador.database.ConnectionFactory;
import br.com.naila.gerenciador.database.dao.CategoriaDao;
import br.com.naila.gerenciador.database.dao.EmpresaDao;
import br.com.naila.gerenciador.modelo.Categoria;
import br.com.naila.gerenciador.modelo.Empresa;

public class ListagemCategoriaTeste {

    public static void main(String[] args) throws SQLException, PropertyVetoException {
	
	try(Connection conexao = new ConnectionFactory().getConnection()){
	    
	    List<Empresa> empresas = new EmpresaDao(conexao).lista();
	    empresas.forEach(System.out::println);
	    
	    List<Categoria> categorias = new CategoriaDao(conexao).listarCategoriasComEmpresas();
	    categorias.forEach(categoria -> {
		System.out.println(categoria.getNome());
		categoria.getEmpresas().forEach(System.out::println);
	    });
	    
	}
    }
}
