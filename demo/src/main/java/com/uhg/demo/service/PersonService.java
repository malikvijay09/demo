package com.uhg.demo.service;

import java.util.List;

import com.uhg.demo.model.Person;


public interface PersonService {

	List<Person> findAll();
	Person create(Person person);
	Person findOne(String id);
	void delete(String id);
	void deleteAll();
}
