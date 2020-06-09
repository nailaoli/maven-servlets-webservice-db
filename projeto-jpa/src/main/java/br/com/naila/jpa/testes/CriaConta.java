package br.com.naila.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.naila.jpa.modelo.Conta;

public class CriaConta {

    public static void main(String[] args) {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
	Conta conta = new Conta();
	conta.setTitular("Naila");
	conta.setNumero(1234);
	conta.setAgencia(4321);
	conta.setSaldo(1000000.0);
	
	em.getTransaction().begin();
	
	em.persist(conta);
	
	em.getTransaction().commit();
	
	emf.close();
	em.close();
    }
}
