package com.person.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.person.entities.Person;

@Service
public interface PersonService {

 // creating person 
	
 Person createPerson(Person person);
 
 // get all persons
 
 List<Person> getAllPerson();
 
 // get person by its id 
 
 Person getPerson(int id);
 
 // delete person by its id
 
 void deletePerson(int id);
 
 // update person by its id
 
 Person updatePerson(int id, Person updatedPerson);
	
}
