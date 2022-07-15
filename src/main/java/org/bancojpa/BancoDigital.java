package org.bancojpa;

import org.bancojpa.model.Cliente;
import org.bancojpa.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BancoDigital {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Banco-JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Cliente cliente = new Cliente();
        cliente.setNome("Banco Digital JPA");

        Conta conta = new Conta();
        conta.setNome("Conta Digital JPA");
        conta.setConta(conta);

        entityManager.getTransaction().begin();

        entityManager.persist(cliente);
        entityManager.persist(conta);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}