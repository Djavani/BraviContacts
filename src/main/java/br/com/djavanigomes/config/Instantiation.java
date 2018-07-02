package br.com.djavanigomes.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.djavanigomes.domain.Contact;
import br.com.djavanigomes.domain.User;
import br.com.djavanigomes.dto.ContactDTO;
import br.com.djavanigomes.dto.UserDTO;
import br.com.djavanigomes.repository.ContactRepository;
import br.com.djavanigomes.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		contactRepository.deleteAll();
		
		User djavani = new User(null, "Djavani Gomes", "djavanirgomes@gmail.com", "32 30262607", "32 991217336", true);
		User arthur = new User(null, "Arthur Louzada", "arthurlouzada@gmail.com", "32 30287452", "32 991217548", false);
		User lucas  = new User(null, "Lucas Alvine", "lalvine@yahoo.com", "32 30290102", "32 991213698", true);
		User fernando  = new User(null, "Fernando Andrade", "fandrade@uol.com.br", "32 30290101", "32 991211478", true);
		User larissa  = new User(null, "Larissa Souza", "lasouza@gmail.com", "24 30292020", "24 987482458", false);
		User nelson  = new User(null, "Nelson Florencio", "nflorencio@gmail.com", "31 3124577", "31 98745214", false);
		
		userRepository.saveAll(Arrays.asList(djavani, arthur, lucas, fernando, larissa, nelson));

		/*Contact contact1 = new Contact(null, "Larissa Souza", "lasouza@gmail.com", "24 30292020", "24 987482458", false, new UserDTO(djavani));
		Contact contact2 = new Contact(null, "Lucas Alvine", "lalvine@yahoo.com", "32 30290102", "32 991213698", true, new UserDTO(fernando));*/
		
		Contact contact1 = new Contact(null, djavani.getId(), djavani.getName(), lucas);
		Contact contact2 = new Contact(null, djavani.getId(), djavani.getName(), fernando);
		
		Contact contact3 = new Contact(null, nelson.getId(), nelson.getName(), djavani);
		Contact contact4 = new Contact(null, nelson.getId(), nelson.getName(), lucas);
		Contact contact5 = new Contact(null, nelson.getId(), nelson.getName(), fernando);
		Contact contact6 = new Contact(null, nelson.getId(), nelson.getName(), arthur);
		Contact contact7 = new Contact(null, lucas.getId(), lucas.getName(), larissa);
		Contact contact8 = new Contact(null, arthur.getId(), arthur.getName(), fernando);
		
		contactRepository.saveAll(Arrays.asList(contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8));
		
		djavani.getContacts().addAll(Arrays.asList(contact1, contact2));
		userRepository.save(djavani);
		
		nelson.getContacts().addAll(Arrays.asList(contact3, contact4, contact5, contact6));
		userRepository.save(nelson);
		
		lucas.getContacts().addAll(Arrays.asList(contact7));
		userRepository.save(lucas);
		
		arthur.getContacts().addAll(Arrays.asList(contact8));
		userRepository.save(arthur);
	}

}
