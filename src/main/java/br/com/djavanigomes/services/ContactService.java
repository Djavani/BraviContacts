package br.com.djavanigomes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.djavanigomes.domain.Contact;
import br.com.djavanigomes.dto.ContactDTO;
import br.com.djavanigomes.repository.ContactRepository;
import br.com.djavanigomes.services.exception.ObjectNotFoundException;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;	

	

	public Contact insert(Contact contact) {
		return contactRepository.save(contact);
	}
	
	public void delete(String id) {
		findById(id);
		contactRepository.deleteById(id);
	}
	
	public Contact findById(String id) {
		Optional<Contact> contact = contactRepository.findById(id);
		return contact.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}	

	public Contact update(Contact contact) {
		Contact newContact = findById(contact.getId());
		updateData(newContact, contact);
		return contactRepository.save(newContact);
	}
	

	private void updateData(Contact newContact, Contact contact) {
		newContact.setUserId(contact.getUserId());
		newContact.setUserName(contact.getUserName());
		newContact.setContact(contact.getContact());
		
	}

	public List<Contact> findAll() {		
		return contactRepository.findAll();
	}
	
	
	public List<Contact> findByUser(String text) {
		return contactRepository.findByUserNameContainingIgnoreCase(text);
	}
	
	public Contact fromDTO(ContactDTO contactDto) {
		return new Contact(contactDto.getId(), contactDto.getUserId(), contactDto.getUserName(), contactDto.getContact());
				
	}
	
}
