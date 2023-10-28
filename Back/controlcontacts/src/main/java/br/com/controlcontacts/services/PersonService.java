package br.com.controlcontacts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlcontacts.exception.ResourceNotFoundException;
import br.com.controlcontacts.dto.PersonDTO;
import br.com.controlcontacts.entities.Person;
import br.com.controlcontacts.repository.PersonRepository;
import br.com.controlcontacts.service.interfaces.PersonServiceInterface;


@Service
public class PersonService implements PersonServiceInterface {
	
	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Optional<Person> getById(Long id) {
		return personRepository.findById(id);	
	}
	
	public 	Optional<PersonDTO> getDTOById(Long id) {
		Person person = personRepository.findById(id).get();
		PersonDTO dto = new PersonDTO(person.getId(), person.getName(),
				person.getAddress() + person.getPostalCode() + person.getCity() + person.getFederalUnit());
		return Optional.ofNullable(dto);
		
	}

	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public Person update(Person person) {
		Optional<Person> upPerson = personRepository.findById(person.getId());
		
		if(upPerson.isPresent()) {
			Person newPerson = upPerson.get();
			newPerson.setContacts(person.getContacts());
			return personRepository.save(newPerson);
		}
		return person;
	}

	@Override
	public void delete(Long id) {
		personRepository.deleteById(id);
	}
	
}
