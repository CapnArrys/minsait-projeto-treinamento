package br.com.controlcontacts.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private ContactType contactType;
	
	@Column(nullable = false)
	private String contact;
	
	@Column
	private Long person;
	
	public Contact() {}
	
	public Contact(Long Id, ContactType contactType, String contact, Long person) {
		this.id = Id;
		this.contactType = contactType;
		this.contact = contact;
		this.person = person;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ContactType getContactType() {
		return contactType;
	}


	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Long getPerson() {
		return person;
	}

	public void setPerson(Long person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
