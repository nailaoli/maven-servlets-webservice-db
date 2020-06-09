package br.com.naila.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // Enum será salvo como String
    private TipoMovimentacao tipoMovimentacao;
    private LocalDateTime data; // classe que possui data e horário
    private String descricao;
    private BigDecimal valor;

    @ManyToOne // representa que podem haver várias movimentações para uma conta
    private Conta conta;

    @ManyToMany // representa que uma movimentação pode ter várias categorias, e uma categoria
		// pode estar em várias movimentações
    private List<Categoria> categorias = new ArrayList<Categoria>();
    
    public void adicionaCategoria(Categoria categoria) {
	categorias.add(categoria);
    }
    

    public List<Categoria> getCategorias() {
	return categorias;
    }

    public void setCategoria(List<Categoria> categoria) {
	this.categorias = categoria;
    }

    public Conta getConta() {
	return conta;
    }

    public void setConta(Conta conta) {
	this.conta = conta;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public TipoMovimentacao getTipoMovimentacao() {
	return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
	this.tipoMovimentacao = tipoMovimentacao;
    }

    public LocalDateTime getData() {
	return data;
    }

    public void setData(LocalDateTime data) {
	this.data = data;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public BigDecimal getValor() {
	return valor;
    }

    public void setValor(BigDecimal valor) {
	this.valor = valor;
    }

}
