package com.infoworld.jpa.repository;

import java.util.Optional;

import com.infoworld.jpa.model.Categoria;

import jakarta.persistence.EntityManager;

public class CategoriaRepository {
	
	private EntityManager entityManager;

	public CategoriaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Optional<Categoria> save(Categoria categoria) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(categoria);
			entityManager.getTransaction().commit();
			return Optional.of(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

}
