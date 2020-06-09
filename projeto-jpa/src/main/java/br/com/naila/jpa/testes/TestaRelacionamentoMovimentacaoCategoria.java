package br.com.naila.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.naila.jpa.modelo.Categoria;
import br.com.naila.jpa.modelo.Conta;
import br.com.naila.jpa.modelo.Movimentacao;
import br.com.naila.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

    public static void main(String[] args) {

	Categoria categoria = new Categoria("Viagem");
	Categoria categoria2 = new Categoria("Negócios");
	
	Conta conta = new Conta();
	conta.setId(1L); // irá dar o update no banco na conta id 1
	
	Movimentacao movimentacao = new Movimentacao();
	movimentacao.setDescricao("Viagem à SP");
	movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
	movimentacao.setData(LocalDateTime.now());
	movimentacao.setValor(new BigDecimal(300.0));
	movimentacao.adicionaCategoria(categoria);
	movimentacao.adicionaCategoria(categoria2);
	movimentacao.setConta(conta);
	
	Movimentacao movimentacao2 = new Movimentacao();
	movimentacao2.setDescricao("Viagem ao RJ");
	movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
	movimentacao2.setData(LocalDateTime.now());
	movimentacao2.setValor(new BigDecimal(400.0));
	movimentacao2.adicionaCategoria(categoria);
	movimentacao2.adicionaCategoria(categoria2);
	movimentacao2.setConta(conta);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	em.persist(categoria);
	em.persist(categoria2);
	em.persist(movimentacao);
	em.persist(movimentacao2);
//	não persisti a conta criada porém o hibernate irá fazer o update na conta de id 1
	
	em.getTransaction().commit();
	
	em.close();
	emf.close();
    }
}
