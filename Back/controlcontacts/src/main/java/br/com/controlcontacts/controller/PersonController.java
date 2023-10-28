package br.com.controlcontacts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlcontacts.dto.PersonDTO;
import br.com.controlcontacts.entities.Person;
import br.com.controlcontacts.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas")
public class PersonController {
	
	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	@Operation(
		      summary = "retorna a lista de pessoas")
	@GetMapping
	public ResponseEntity<List<Person>> getAll(){
		List<Person> persons = personService.getAll();
		if(persons == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(persons);
	}
	
	@Operation(
		      summary = "retornando uma pessoa por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Person>> getById(@PathVariable Long id){
		Optional<Person> person = personService.getById(id);
		if(person == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(person);
	}
	
	@Operation(
		      summary = "retornando de pessoa por Id para mala direta")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<Optional<PersonDTO>> getDTOById(@PathVariable Long id){
		Optional<PersonDTO> person = personService.getDTOById(id);
		if(person == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(person);
	}
	
	 @Operation(
		      summary = "salvando uma pessoa")
	@PostMapping
	public ResponseEntity<Person> save(@RequestBody Person person){
		return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
	}
	 @Operation(
		      summary = "Atualizando a pessoa")
	@PutMapping
	public ResponseEntity<Person> update(@RequestBody Person person){
		return new ResponseEntity<>(personService.update(person), HttpStatus.CREATED);
	}
	 
	 @Operation(
		      summary = "deletando uma pessoa por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		personService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}