package br.com.naila.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.naila.jpa.modelo.Conta;

public class AlteraSaldoContaNaila {

    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
	EntityManager em = emf.createEntityManager();
	
//	Encontra no banco de dados baseado na classe e primary key
	Conta contaDaNaila = em.find(Conta.class, 1L);
//	System.out.println(contaDaNaila.getTitular()); //output: Naila
	
	em.getTransaction().begin();
	contaDaNaila.setSaldo(1000000.0);
	em.getTransaction().commit();
	
	contaDaNaila.setSaldo(500000.0);
	
	em.close();
	emf.close();
    }

}
