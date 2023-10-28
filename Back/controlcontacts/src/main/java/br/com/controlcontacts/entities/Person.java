package br.com.controlcontacts.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "person")
public class Person {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = true)
	private String address;
	
	@Column(nullable = true)
	private String postalcode;
	
	@Column(nullable = true)
	private String city;
	
	@Column(nullable = true)
	private String federealUnit;
	
	@OneToMany(mappedBy="Person")
	private List<Contact> contacts;
	
	
	
}
