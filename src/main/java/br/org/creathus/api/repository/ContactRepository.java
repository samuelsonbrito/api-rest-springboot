package br.org.creathus.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.creathus.api.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	Contact findById(long id);
	
}
