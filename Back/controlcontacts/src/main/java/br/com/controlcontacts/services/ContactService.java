package br.com.controlcontacts.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlcontacts.exception.ResourceNotFoundException;
import br.com.controlcontacts.entities.Contact;
import br.com.controlcontacts.repository.ContactRepository;
import br.com.controlcontacts.service.interfaces.ContactServiceInterface;

	@Service
	public class ContactService implements ContactServiceInterface {

		private ContactRepository contactRepository;
		
		@Autowired
		public ContactService(ContactRepository contactRepository) {
			this.contactRepository = contactRepository;
		}
		
		@Override
		public Contact save(Contact contact) {
			return contactRepository.save(contact);
		}

		@Override
		public Optional<Contact> getById(Long id) {
			return contactRepository.findById(id);
		}

		@Override
		public List<Contact> getAll() {
			return contactRepository.findAll();
		}

		@Override
		public Contact update(Long id, Contact contact) {
			//encontrei o produto
			Optional<Contact> upContact = contactRepository.findById(id);
			
			//se ele existir, atualizar:
			if(upContact.isPresent()) {
				Contact newContact = upContact.get();
				newContact.setId(contact.getId());
				newContact.setContact(contact.getContact());
				newContact.setContactType(contact.getContactType());
				return contactRepository.save(newContact);
			}
			
			
			return contact;
		}

		@Override
		public void delete(Long id) {
			contactRepository.deleteById(id);
			
		}



	

}
