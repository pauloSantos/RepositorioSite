package com.site.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PrincipalDAO {

	EntityManager manager;
	
	public PrincipalDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("site");
		manager = factory.createEntityManager();
	}
	
	public EntityManager getEntityManager(){
		return manager;
	}
	
	public void insert(Object obj){
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
	}
	
	public void update(Object obj){
		manager.getTransaction().begin();
		manager.merge(obj);
		manager.getTransaction().commit();
	}
}
