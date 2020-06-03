package br.com.naila.gerenciador.modelo;

import java.time.LocalDate;

public class Empresa {

    private Integer id;
    private String nome;
    private LocalDate data;
    private Categoria categoria;

    public Empresa(String nome) {
	this.nome = nome;
    }
       
    public Empresa(Integer id, String nome, LocalDate data) {
	this.nome = nome;
	this.id = id;
	this.data = data;
    }
    
    public Empresa(Integer id, String nome, LocalDate data, Categoria categoria) {
	this.nome = nome;
	this.id = id;
	this.data = data;
	this.categoria = categoria;
    } 
    
    public Empresa(String nome, LocalDate data, Categoria categoria) {
	this.nome = nome;
	this.data = data;
	this.categoria = categoria;
    } 

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public LocalDate getData() {
	return data;
    }
    
    public Categoria getCategoria() {
	return this.categoria;
    }

    public void setData(LocalDate data) {
	this.data = data;
    }
    
    @Override
    public String toString() {
        return String.format("%d - %s - %s", this.id, this.nome, this.data.toString());
    }

}
