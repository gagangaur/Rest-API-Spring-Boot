package com.spring.restapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.restapi.entities.User;
import com.spring.restapi.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		System.out.println("Inside get all user method");
		return (List<User>) userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}

	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
			userRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public void updateUser(@RequestBody User user,@PathVariable Long id) {
		System.out.println("inside update method");
		User oldUser = userRepository.findById(id).get();
		oldUser.setName(user.getName());
		oldUser.setPassword(user.getPassword());
		userRepository.save(oldUser);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
}
