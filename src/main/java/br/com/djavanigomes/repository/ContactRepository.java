package br.com.djavanigomes.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.djavanigomes.domain.Contact;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {
		
	List<Contact> findByUserNameContainingIgnoreCase(String text);
}
