package br.com.naila.gerenciador.modelo;

import java.util.Date;

public class Empresa {

    private Integer id;
    private String nome;
    private Date data = new Date();

    public Empresa(String nome) {
	this.nome = nome;
    }
    
    public Empresa(String nome, Integer id) {
	this.nome = nome;
	this.id = id;
    }

    public Integer getId() {
	return id;
    }

    void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Date getData() {
	return data;
    }

    public void setData(Date data) {
	this.data = data;
    }

}
