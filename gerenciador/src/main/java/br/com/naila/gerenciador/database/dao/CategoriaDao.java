package br.com.naila.gerenciador.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.naila.gerenciador.modelo.Categoria;
import br.com.naila.gerenciador.modelo.Empresa;

public class CategoriaDao {

    private Connection conexao;

    public CategoriaDao(Connection conexao) {
	this.conexao = conexao;
    }

    public List<Categoria> listaCategorias() throws SQLException {
	List<Categoria> categorias = new ArrayList<>();
	String sql = "SELECT id, nome FROM categorias";
	try (PreparedStatement stm = conexao.prepareStatement(sql)) {
	    System.out.println("Query: listar categorias");
	    stm.execute();
	    try (ResultSet rst = stm.getResultSet()) {
		while (rst.next()) {
		    categorias.add(new Categoria(rst.getInt(1), rst.getString(2)));
		}
	    }
	    return categorias;
	}
    }

    public List<Categoria> listarCategoriasComEmpresas() throws SQLException {

	List<Categoria> categorias = new ArrayList<>();

	String sql = "SELECT c.id, c.nome, e.id, e.nome, e.data FROM categorias c INNER JOIN empresa e ON c.id = e.categoria_id;";

	try (PreparedStatement stm = conexao.prepareStatement(sql)) {
	    System.out.println("Executando query de buscar categorias com empresas");
	    stm.execute();

	    ResultSet rst = stm.getResultSet();

	    Categoria ultimaCategoria = null;

	    while (rst.next()) {

		Empresa empresa = new Empresa(rst.getInt(3), rst.getString(4), rst.getDate(5).toLocalDate());
		Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));

		if (ultimaCategoria == null || !categoria.getNome().equals(ultimaCategoria.getNome())) {
		    ultimaCategoria = categoria;
		    categorias.add(ultimaCategoria);
		}

		ultimaCategoria.adicionaEmpresa(empresa);

//		if (categorias.contains(categoria)) {
//		    categorias
//		    	.stream()
//		    	.filter(c -> c.equals(categoria))
//		    	.findFirst()
//			.ifPresent(c -> c.adicionaEmpresa(empresa));
//		} else {
//		    categoria.adicionaEmpresa(empresa);
//		    categorias.add(categoria);
//		}
	    }
	    rst.close();
	}
	return categorias;
    }
}
