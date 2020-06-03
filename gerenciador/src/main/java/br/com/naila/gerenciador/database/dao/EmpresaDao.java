package br.com.naila.gerenciador.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.naila.gerenciador.modelo.Categoria;
import br.com.naila.gerenciador.modelo.Empresa;

public class EmpresaDao {

    private Connection conexao;

    public EmpresaDao(Connection conexao) {
	this.conexao = conexao;
    }

    
    public void adiciona(Empresa empresa) throws SQLException {

	try (PreparedStatement stm = conexao.prepareStatement("INSERT INTO empresa (nome, data, categoria_id) VALUES (?, ?, ?)",
		Statement.RETURN_GENERATED_KEYS)) {

	    stm.setString(1, empresa.getNome());
	    stm.setObject(2, empresa.getData());
	    stm.setObject(3, empresa.getCategoria().getId());
	    stm.execute();

	    try (ResultSet rst = stm.getGeneratedKeys()) {
		while (rst.next()) {
		    Integer id = rst.getInt(1);
		    empresa.setId(id);
		    System.out.println("Adicionado ao banco de dados id: " + id);
		}
	    }
	}
    }
    

    public List<Empresa> lista() throws SQLException {

	List<Empresa> empresas = new ArrayList<>();

	try (PreparedStatement stm = this.conexao.prepareStatement("SELECT id, nome, data FROM empresa;")) {
	    System.out.println("Query: listar empresas");
	    stm.execute();
	    try (ResultSet rst = stm.getResultSet()) {
		while (rst.next()) {
		    Empresa empresa = new Empresa(rst.getInt(1), rst.getString(2), rst.getDate(3).toLocalDate());
		    empresas.add(empresa);
		}
	    }
	}

	return Collections.unmodifiableList(empresas);
    }
    

    public List<Empresa> busca(Categoria categoria) throws SQLException {
	List<Empresa> empresas = new ArrayList<>();

	try (PreparedStatement stm = this.conexao
		.prepareStatement("SELECT id, nome, data FROM empresa WHERE categoria_id = ?;")) {
	    stm.setInt(1, categoria.getId());
	    System.out.println("Query: buscar empresas pela categoria");
	    stm.execute();
	    try (ResultSet rst = stm.getResultSet()) {
		while (rst.next()) {
		    Empresa empresa = new Empresa(rst.getInt(1), rst.getString(2), rst.getDate(3).toLocalDate());
		    empresas.add(empresa);
		}
	    }
	}
	return Collections.unmodifiableList(empresas);
    }
    

    public void altera(Empresa empresa) throws SQLException {
	String sql = "UPDATE empresa SET nome = ?, data = ?, categoria_id = ? WHERE id = ?";
	try (PreparedStatement stm = this.conexao.prepareStatement(sql)) {
	    stm.setString(1, empresa.getNome());
	    stm.setObject(2, empresa.getData());
	    stm.setInt(3, empresa.getCategoria().getId());
	    stm.setInt(4, empresa.getId());
	    System.out.println("Query: alterar empresa");
	    stm.execute();
	}
    }

    
    public Empresa buscaPeloId(Integer id) throws SQLException {
	Empresa empresa = null;
	String sql = "SELECT e.id, e.nome, e.data, c.id, c.nome FROM empresa e INNER JOIN categorias c WHERE c.id = e.categoria_id AND e.id = ?;";
	try (PreparedStatement stm = this.conexao.prepareStatement(sql)) {
	    stm.setInt(1, id);
	    System.out.println("Query: buscar empresa pelo id");
	    stm.execute();	    
	    try (ResultSet result = stm.getResultSet()) {
		result.next();
		empresa = new Empresa(result.getInt(1), result.getString(2), result.getDate(3).toLocalDate(),
			new Categoria(result.getInt(4), result.getString(5)));
	    }
	}
	return empresa;
    }
    
    
    public void removeEmpresa(Integer id) throws SQLException {
	String sql = "DELETE FROM empresa WHERE id = ?";
	try (PreparedStatement stm = this.conexao.prepareStatement(sql)) {
	    stm.setInt(1, id);
	    System.out.println("Query: remover empresa");
	    stm.execute();
	}
    }
    
    
}
