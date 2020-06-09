package br.com.naila.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.naila.jpa.modelo.Cliente;
import br.com.naila.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {

    public static void main(String[] args) {

	Conta conta = new Conta();
	conta.setId(1L);

	Cliente cliente = new Cliente();
	cliente.setNome("Naila");
	cliente.setEndereco("Rua do Ouvidor, 100");
	cliente.setProfissao("Dev");
	cliente.setConta(conta);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();

	em.persist(cliente);
	
	em.getTransaction().commit();

	em.close();
	emf.close();

    }

}
