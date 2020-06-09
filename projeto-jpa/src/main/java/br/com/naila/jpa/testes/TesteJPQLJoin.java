package br.com.naila.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.naila.jpa.modelo.Categoria;
import br.com.naila.jpa.modelo.Movimentacao;
import br.com.naila.jpa.modelo.TipoMovimentacao;

public class TesteJPQLJoin {

    public static void main(String[] args) {

	String jpql = "select m from Movimentacao m JOIN m.categorias c "
		+ "WHERE c = :pCategoria AND m.valor > 300.0 AND m.tipoMovimentacao = :pTipoMovimentacao";

	Categoria categoria = new Categoria("Viagem");
	categoria.setId(1L);

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();

	TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
	query.setParameter("pCategoria", categoria);
	query.setParameter("pTipoMovimentacao", TipoMovimentacao.SAIDA);
	
	List<Movimentacao> movimentacoes = query.getResultList();
	movimentacoes.forEach(m -> {
	    System.out.println("Categoria: " + m.getCategorias());
	    System.out.println("Descrição: " + m.getDescricao());
	    System.out.println("Valor: " + m.getValor());
	    System.out.println("Tipo: " + m.getTipoMovimentacao());
	});

	em.close();
	emf.close();
    }

}
