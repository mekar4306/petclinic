package com.javaegitimleri.petclinic.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaegitimleri.petclinic.dao.OwnerRepositoryDAO;
import com.javaegitimleri.petclinic.model.Owner;

@Repository
public class OwnerRepositoryDAOInMemoryImpl implements OwnerRepositoryDAO{

	private Map<Long, Owner> ownersMap=new HashMap<>();
	
	public OwnerRepositoryDAOInMemoryImpl() {
		
		/*Owner owner1=new Owner(1L, "Mehmet", "KARADAYI");
		Owner owner2=new Owner(2L, "Hatice", "KARADAYI");
		Owner owner3=new Owner(3L, "Azra", "KARADAYI");
		Owner owner4=new Owner(4L, "Kerem", "AKGÜN");*/
		
		/*ownersMap.put(owner1.getId(),  owner1);
		ownersMap.put(owner2.getId(),  owner2);
		ownersMap.put(owner3.getId(),  owner3);
		ownersMap.put(owner4.getId(),  owner4);*/
		
		
		
	}
	
	
	@Override
	public List<Owner> findAll() {
		//return (List<Owner>) ownersMap.values();
		
		return new ArrayList<>(ownersMap.values());
	}

	@Override
	public Owner findById(Long id) {
		return  ownersMap.get(id);
		
	}

	@Override
	public List<Owner> findByLastName(String lastname) {
		// TODO Auto-generated method stub
		return ownersMap.values().stream().filter(o->o.getLastName().equals(lastname)).collect(Collectors.toList());
	}

	@Override
	public void create(Owner owner) {
		owner.setId(new Date().getTime());
		ownersMap.put(owner.getId(),owner);
		
	}

	@Override
	public Owner update(Owner owner) {
		// TODO Auto-generated method stub
		 ownersMap.replace(owner.getId(), owner);
		 return owner;
	}

	@Override
	public void delete(Long id) {
		ownersMap.remove(id);
		
	}

}
