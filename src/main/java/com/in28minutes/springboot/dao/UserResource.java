package com.in28minutes.springboot.dao;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.exception.UserNotFound;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user==null)
			throw new UserNotFound("id-"+ id);
		/////////////////////////////////  with new version ////////////////////
//		EntityModel<User> resource = EntityModel.of(user);
//		WebMvcLinkBuilder linkTo = 
//				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		
		////////////////////////////   with past version   /////////////////////
		//"all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		Resource<User> resource = new Resource<User>(user);
		List<Link> linkTo = new ArrayList<>();
		linkTo.add(linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users"));
		linkTo.add(linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("Suers"));

//		System.out.println("hnaaaaaaaaaaa  2");

		resource.add(linkTo);
		//HATEOAS
		
		
		
		///////////////////////////////////////////
		
//		List<Resource<User>> emp = new ArrayList<>();
//		
//		Resource<User> resource = new Resource<User>(user);
//		ControllerLinkBuilder linkTo = 
//				linkTo(methodOn(this.getClass()).retrieveAllUsers());
////		System.out.println("hnaaaaaaaaaaa  2");
//
//		resource.add(linkTo.withRel("all-users"));
//		
//		emp.add(resource);
//		
		
		
		
		return resource;
		
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user==null)
			throw new UserNotFound("id-"+ id);		
	}

	//
	// input - details of user
	// output - CREATED & Return the created URI
	
	//HATEOAS
	
	@PostMapping("/users")
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// CREATED
		// /user/{id}     savedUser.getId()
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}