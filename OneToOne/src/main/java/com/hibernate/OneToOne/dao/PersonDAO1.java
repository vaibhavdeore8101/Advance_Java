package com.hibernate.OneToOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hibernate.OneToOne.dto.AadharCard;

public class PersonDAO1 {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void openConnection() {
		
		entityManagerFactory=Persistence.createEntityManagerFactory("person");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	public static void closeConnection() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if(entityManager!=null) {
			entityManager.close();
		}
		if(entityTransaction!=null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		AadharCard adharCard=entityManager.find(AadharCard.class, 1);
		entityManager.remove(adharCard);
		
		entityTransaction.commit();
		closeConnection();
	}

}
