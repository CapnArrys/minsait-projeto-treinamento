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

import br.com.controlcontacts.entities.Contact;
import br.com.controlcontacts.services.ContactService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/contatos")
public class ContactController {
	
	private ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	 @Operation(
		      summary = "retorna a lista de todos os contatos")
	@GetMapping
	public ResponseEntity<List<Contact>> getAll(){
		List<Contact> contacts = contactService.getAll();
		if(contacts == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contacts);
	}
	 @Operation(
		      summary = "retornando um contato por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contact>> getById(@PathVariable Long id){
		Optional<Contact> contact = contactService.getById(id);
		if(contact == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contact);
	}
	 @Operation(
		      summary = "Salvando o contato")
	@PostMapping
	public ResponseEntity<Contact> save(@RequestBody Contact contact){
		return new ResponseEntity<>(contactService.save(contact), HttpStatus.CREATED);
	}
	 @Operation(
		      summary = "Atualizando o contato")
	@PutMapping
	public ResponseEntity<Contact> update(@RequestBody Contact contact){
		return new ResponseEntity<>(contactService.update(contact), HttpStatus.CREATED);
	}
	
	 @Operation(
		      summary = "deletando um contato por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contactService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}