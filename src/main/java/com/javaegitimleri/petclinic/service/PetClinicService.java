package com.javaegitimleri.petclinic.service;

import java.util.List;

import com.javaegitimleri.petclinic.exception.OwnerNotFoundException;
import com.javaegitimleri.petclinic.exception.VetNotFoundException;
import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.model.Vet;

public interface PetClinicService {
	
	List<Owner> findOwners();
	List<Owner> findOwners(String LastName);
	Owner findOwnerById(Long id) throws OwnerNotFoundException;
	
	void createOwner(Owner owner);
	void updateOwner(Owner owner);
	void deleteOwner(Long id);
	
	
	List<Vet> findVets();
	
	Vet findById(Long id) throws VetNotFoundException;

}
