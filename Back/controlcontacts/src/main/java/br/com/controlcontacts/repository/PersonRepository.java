package br.com.controlcontacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.controlcontacts.entities.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	

}
