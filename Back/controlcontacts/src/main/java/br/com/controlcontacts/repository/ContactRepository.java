package br.com.controlcontacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.controlcontacts.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
