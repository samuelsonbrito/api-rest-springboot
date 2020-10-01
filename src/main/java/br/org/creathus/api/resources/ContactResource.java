package br.org.creathus.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.creathus.api.models.Contact;
import br.org.creathus.api.repository.ContactRepository;

@RestController
@RequestMapping(value = "/api")
public class ContactResource {
	
	@Autowired
	ContactRepository contactRepository;
	
	@GetMapping("contatos")
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}
	
	@GetMapping("contato/{id}")
	public Contact findById(@PathVariable(value="id") long id){
		return contactRepository.findById(id);
	}
	
	@PostMapping("contato")
	public Contact save(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	@DeleteMapping("contato")
	public void dalete(@RequestBody Contact contact) {
		contactRepository.delete(contact);
	}
	
	@PutMapping("contato")
	public Contact update(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
}
