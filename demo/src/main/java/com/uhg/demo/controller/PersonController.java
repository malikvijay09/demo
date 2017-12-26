package com.uhg.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uhg.demo.model.Person;
import com.uhg.demo.service.PersonService;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	
	
	@GetMapping("/persons")
	public List<Person> getAllPersons(){
		System.out.println("GET ALL ");
		return personService.findAll();
	}
	
	@PostMapping("/persons/create")
	public Person createPerson(@Valid @RequestBody Person person) {
		return personService.create(person);
	}
	
	
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") String id, @RequestBody Person person) {
		
		Person personData = personService.findOne(id);
		
		if(person == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		personData.setFirstName(person.getFirstName());
		personData.setLastName(person.getLastName());
		personData.setAge(person.getAge());
		personData.setActive(person.isActive());
		
		Person updatePerson = personService.create(personData);
		return new ResponseEntity<>(updatePerson, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/persons/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable("id") String id){	
		personService.delete(id);
		return new ResponseEntity<>("Person has been deleted !",HttpStatus.OK);
		
	}
	
	@DeleteMapping("/persons/delete")
	public ResponseEntity<String> deleteAllPersons(){
		
		personService.deleteAll();
		return new ResponseEntity<>("All persons has been deleted !",HttpStatus.OK);
	}
	
	
	
	

}
