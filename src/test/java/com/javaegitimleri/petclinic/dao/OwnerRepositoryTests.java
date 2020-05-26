package com.javaegitimleri.petclinic.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.validation.Constraint;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.javaegitimleri.petclinic.model.Owner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class OwnerRepositoryTests {
	
	
	@Autowired
	private OwnerRepositoryDAO ownerRepositoryDAO;
	
	@Autowired 
	private EntityManager entityManager;
	
	@Test(expected=PersistenceException.class)
	public void testCreateOwner(){
		
			Owner owner = new Owner();
			owner.setFirstName(null);
			owner.setLastName(null);
			
			ownerRepositoryDAO.create(owner);
			
			entityManager.flush();
		
		
	}

}
