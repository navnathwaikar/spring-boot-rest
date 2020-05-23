package com.example.springbootrest.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springbootrest.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {

		return service.findAll();

	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id - "+id);
		}
		
		return user;
	}
	

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		//created
		//return path -- //users/{id} 
		
		User savedUser = service.save(user);
	
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
		
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = service.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id - "+id);
		}
		
	}
	
}
