package br.com.djavanigomes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.djavanigomes.domain.User;
import br.com.djavanigomes.dto.UserDTO;
import br.com.djavanigomes.repository.UserRepository;
import br.com.djavanigomes.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}	

	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return userRepository.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPhone(user.getPhone());
		newUser.setMobilePhone(user.getMobilePhone());
		newUser.setWhatsapp(user.isWhatsapp());
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail(), 
				userDto.getPhone(),  userDto.getMobilePhone(), userDto.isWhatsapp());
	}

}
