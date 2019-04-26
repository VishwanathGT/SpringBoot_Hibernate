package com.vishwa.rest;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishwa.model.UserDetails;
import com.vishwa.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/allUsers")
	public List<UserDetails> getAllNotes() {
	    return userRepository.findAll();
	}
	
	// Create a new Note
	@PostMapping("/user")
	public UserDetails createNote(@Valid @RequestBody UserDetails note) {
	    return userRepository.save(note);
	}
	
	//Validating user by username password
	@PostMapping("/validateUser")
	public UserDetails validateUser1(@Valid @RequestBody UserDetails user) {
		return userRepository.validateUser(user.getLoginName(), user.getPassword());
	}
}
