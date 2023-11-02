package br.com.controlcontacts.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.controlcontacts.entities.Contact;


public interface ContactServiceInterface {
	
	Contact save(Long idPerson, Contact contact);
	Optional<Contact> getById(Long id);
	List<Contact> getAll();
	List<Contact> getAllByPerson(Long idPerson);
	Contact update(Long id, Contact contact);
	void delete(Long id);

	

}
