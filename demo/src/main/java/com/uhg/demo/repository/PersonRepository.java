package com.uhg.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uhg.demo.model.Person;

public interface PersonRepository extends MongoRepository<Person,String>{

}
