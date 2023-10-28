package br.com.controlcontacts.service.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.controlcontacts.entities.Person;

public interface PersonServiceInterface {
	
	Person save(Person person);
	Optional<Person> getById(Long id);
	List<Person> getAll();
	Person update(Person person);
	void delete(Long id);


}
