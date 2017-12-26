package com.uhg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhg.demo.model.Person;
import com.uhg.demo.repository.PersonRepository;

@Service("personService")
public class PersonServiceImpl implements PersonService{
	
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> findAll() {		
		return personRepository.findAll();
	}

	@Override
	public Person create(Person person) {
		return personRepository.save(person);
	}


	@Override
	public Person findOne(String id) {
		return personRepository.findOne(id);
	}

	@Override
	public void delete(String id) {
		personRepository.delete(id);
	}

	@Override
	public void deleteAll() {
		personRepository.deleteAll();
		
	}

}
