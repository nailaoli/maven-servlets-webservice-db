package br.com.naila.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.naila.jpa.modelo.Conta;
import br.com.naila.jpa.modelo.Movimentacao;

public class TesteJPQL {

    public static void main(String[] args) {
	
	String jpql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
//	Deve se colocar pontos na frente do nome do parâmetro
//	Por convenção se coloca, antes do nome do parâmetro, um "p", para que fique mais claro
	
	Conta conta = new Conta();
	conta.setId(1L);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
	query.setParameter("pConta", conta); // Atribui a variável conta ao parâmetro conta da query
	List<Movimentacao> movimentacoes = query.getResultList();
	movimentacoes.forEach(m -> {
	   System.out.println("Descrição: " + m.getDescricao());
	   System.out.println("Valor: " + m.getValor());
	   System.out.println("Tipo: " + m.getTipoMovimentacao());
	});
	
	em.close();
	emf.close();
    }
}
