package com.javaegitimleri.petclinic.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.javaegitimleri.petclinic.dao.OwnerRepositoryDAO;
import com.javaegitimleri.petclinic.model.Owner;


@Repository("ownerRepositoryDAO")
public class OwnerRepositoryJPAImpl implements OwnerRepositoryDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Owner> findAll() {
		
		return entityManager.createQuery("from Owner", Owner.class).getResultList();	}

	@Override
	public List<Owner> findByLastName(String lastname) {
		return entityManager.createQuery("from Owner where lastName = :lastName", Owner.class).setParameter("lastName", lastname).getResultList();
	}

	
	@Override
	public Owner findById(Long id) {
		// TODO Auto-generated method stub
	   return entityManager.find(Owner.class, id);
	}

	@Override
	public void create(Owner owner) {
		entityManager.persist(owner);

	}

	@Override
	public Owner update(Owner owner) {
		// TODO Auto-generated method stub
		return entityManager.merge(owner);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(   entityManager.getReference(Owner.class, id)    );

	}

}
