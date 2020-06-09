package br.com.naila.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.naila.jpa.modelo.Conta;

public class TestandoEstados {

    public static void main(String[] args) {

//	Estado TRANSIENT
	Conta conta = new Conta();
	conta.setTitular("Almiro");
	conta.setAgencia(4564);
	conta.setNumero(454454);
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
//	TRANSIENT -> MANAGED
	em.persist(conta);
	
//	MANAGED -> REMOVED
	em.remove(conta);
	
	em.getTransaction().commit();
	
	em.close();
	
	EntityManager em2 = emf.createEntityManager();
	
	em2.getTransaction().begin();
	em2.merge(conta);
	em2.getTransaction().commit();
	
	
	emf.close();
	
	
	
	
    }

}
