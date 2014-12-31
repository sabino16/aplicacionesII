package com.servicios.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeneralHome {

	EntityManagerFactory entityManagerFactory;
	
	public EntityManager initEntityManager() {
		 entityManagerFactory = Persistence.createEntityManagerFactory("WebServiceSAAP");
		 return entityManagerFactory.createEntityManager();
	}
	
	public void closeEntityManager(EntityManager entityManager){
		entityManager.close();
		entityManagerFactory.close();
	}
	
	
}
