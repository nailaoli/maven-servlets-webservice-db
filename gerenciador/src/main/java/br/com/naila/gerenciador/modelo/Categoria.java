package br.com.naila.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categoria {

    private String nome;
    private Integer id;
    List<Empresa> listaDeEmpresas = new ArrayList<>();

    public Categoria(Integer id, String nome) {
	this.nome = nome;
	this.id = id;
    }
    
    public Categoria(Integer id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return String.format("%d - %s", id, nome);
    }

    public int getId() {
	return this.id;
    }

    public String getNome() {
	return this.nome;
    }

    public void adicionaEmpresa(Empresa empresa) {
	listaDeEmpresas.add(empresa);
    }
    
    public List<Empresa> getEmpresas(){
	return Collections.unmodifiableList(listaDeEmpresas);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Categoria other = (Categoria) obj;
	if (nome == null) {
	    if (other.nome != null)
		return false;
	} else if (!nome.equals(other.nome))
	    return false;
	return true;
    }
}
