package com.javaegitimleri.petclinic.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.javaegitimleri.petclinic.dao.OwnerRepositoryDAO;
import com.javaegitimleri.petclinic.dao.PetRepositoryDAO;
import com.javaegitimleri.petclinic.dao.jpa.VetRepository;
import com.javaegitimleri.petclinic.exception.OwnerNotFoundException;
import com.javaegitimleri.petclinic.exception.VetNotFoundException;
import com.javaegitimleri.petclinic.model.Owner;
import com.javaegitimleri.petclinic.model.Vet;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor=Exception.class)
public class PetClinicServiceImpl implements PetClinicService{

	
	private OwnerRepositoryDAO ownerRepositoryDAO;
	
	
	private PetRepositoryDAO petRepositoryDAO;

	@Autowired
	private JavaMailSender  javaMailSender;
	
	
	private VetRepository vetRepository;
	
	@Autowired
	public void setVetRepository(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}
	
	@Autowired
	public void setOwnerRepositoryDAO(OwnerRepositoryDAO ownerRepositoryDAO) {
			this.ownerRepositoryDAO = ownerRepositoryDAO;
	}
	

	@Autowired
	public void setPetRepositoryDAO(PetRepositoryDAO petRepositoryDAO) {
		this.petRepositoryDAO = petRepositoryDAO;
	}

	
	
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	@Secured(value= {"ROLE_USER","ROLE_EDITOR"})
	public List<Owner> findOwners() {
		
		return ownerRepositoryDAO.findAll();
	}
	
	
	

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<Owner> findOwners(String lastName) {
		
		return ownerRepositoryDAO.findByLastName(lastName);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public Owner findOwnerById(Long id) throws OwnerNotFoundException {
		Owner owner=ownerRepositoryDAO.findById(id);
		
		if (owner==null) {
			throw new OwnerNotFoundException("Owner bulunamadı: "+id);	
		}
		
		return owner;
	}

	@Override
	public void createOwner(Owner owner) {
	ownerRepositoryDAO.create(owner);
	
		SimpleMailMessage msg=new SimpleMailMessage();
		
		msg.setFrom("info@karaayi.com");
		msg.setTo("azra@karadayi.com");
		msg.setSubject("Owner created!!!!");
		msg.setText("Owner entity with id: "+owner.getId()+"created succesfully!!!");
		
		javaMailSender.send(msg);
		
	}

	@Override
	public void updateOwner(Owner owner) {
		ownerRepositoryDAO.update(owner);
		
	}

	@Override
	public void deleteOwner(Long id) {
		
		petRepositoryDAO.deleteByOwnerId(id);
		ownerRepositoryDAO.delete(id);
		
	 //if(true) throw new RuntimeException("testing rollback...");
		
	}


	@Override
	public List<Vet> findVets() {
		// TODO Auto-generated method stub
		return vetRepository.findAll();
	}


	@Override
	public Vet findById(Long id) throws VetNotFoundException {
		// TODO Auto-generated method stub
		return vetRepository.findById(id).orElseThrow(()->{return new VetNotFoundException("Vet not found by id:"+id);});
	}






	
	

}
