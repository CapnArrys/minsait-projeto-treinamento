package br.com.controlcontacts.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.controlcontacts.entities.Contact;


public interface ContactServiceInterface {
	
	Contact save(Contact contact);
	Optional<Contact> getById(Long id);
	List<Contact> getAll();
	Contact update(Long id, Contact contact);
	void delete(Long id);

	

}
