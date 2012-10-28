package com.site.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class PrincipalDAO {

	protected EntityManager manager;
	
	public PrincipalDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("site");
		manager = factory.createEntityManager();
	}
	
	public EntityManager getEntityManager(){
		return manager;
	}
	
	public void inserir(Object obj){
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
	}
	
	public void atualizar(Object obj){
		manager.getTransaction().begin();
		manager.merge(obj);
		manager.getTransaction().commit();
	}
}
