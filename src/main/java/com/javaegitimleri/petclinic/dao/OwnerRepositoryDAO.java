package com.javaegitimleri.petclinic.dao;

import java.util.List;

import com.javaegitimleri.petclinic.model.Owner;

public interface OwnerRepositoryDAO {
	
	List<Owner> findAll();
	List<Owner> findByLastName(String lastname);
	Owner findById(Long id);
	
	
	void create(Owner owner);
	Owner update(Owner owner);
	void delete(Long id);

}
