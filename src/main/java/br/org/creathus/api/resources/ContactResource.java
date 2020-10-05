package br.org.creathus.api.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.creathus.api.models.Contact;
import br.org.creathus.api.repository.ContactRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Contatos")
public class ContactResource {
	
	@Autowired
	ContactRepository contactRepository;
	
	@ApiOperation(value="Retorna lista de contatos")
	@GetMapping("contatos")
	public List<Contact> findAll(){
		return contactRepository.findAll();
	}
	
	@ApiOperation(value="Retorna contato único")
	@GetMapping("contato/{id}")
	public Contact findById(@PathVariable(value="id") long id) {
		return contactRepository.findById(id);
	}
	
	@ApiOperation(value="Salva contato")
	@PostMapping("contato")
	@ResponseStatus(HttpStatus.CREATED)
	public Contact save(@RequestBody @Valid Contact contact) {
		return contactRepository.save(contact);
	}
	
	@ApiOperation(value="Deleta contato")
	@DeleteMapping("contato/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void dalete(@PathVariable(value="id") long id) {
		contactRepository.deleteById(id);
	}
	
	@ApiOperation(value="Atualiza contato")
	@PutMapping("contato")
	public Contact update(@RequestBody @Valid Contact contact) {
		return contactRepository.save(contact);
	}
	
}
