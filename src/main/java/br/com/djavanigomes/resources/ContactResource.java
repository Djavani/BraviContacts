package br.com.djavanigomes.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.djavanigomes.domain.Contact;
import br.com.djavanigomes.dto.ContactDTO;
import br.com.djavanigomes.resources.util.URL;
import br.com.djavanigomes.services.ContactService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/contacts")
public class ContactResource {
	
	@Autowired
	private ContactService contactService;
	
	@ApiOperation(value="Busca todos os contatos cadastrados.")
	@GetMapping
	public ResponseEntity<List<Contact>> findAll() {		
		List<Contact> list = contactService.findAll();		
		return ResponseEntity.ok().body(list);
	}
		
	@ApiOperation(value="Busca contatos de um unome de suario passado por parametro.")
	@GetMapping(value="/nomesearch")
	public ResponseEntity<List<Contact>> findByUserName(@RequestParam(value ="text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Contact> contacts = contactService.findByUser(text);
		return ResponseEntity.ok().body(contacts);
	}
	
	@ApiOperation(value="Grava um novo contato para um usuário.")
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ContactDTO contactDto) {		
		Contact contact = contactService.fromDTO(contactDto);
		contact = contactService.insert(contact);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contact.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value="Deleta um contato.")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		contactService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Edita informações de um contato.")
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody ContactDTO contactDto, @PathVariable String id) {
		Contact contact = contactService.fromDTO(contactDto);
		contact.setId(id);
		contact = contactService.update(contact);
		return ResponseEntity.noContent().build();
	}
	
	

}
