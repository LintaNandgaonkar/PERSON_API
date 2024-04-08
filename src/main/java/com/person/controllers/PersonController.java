package com.person.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.entities.Person;
import com.person.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody Person person)
	{
		Person person2 = personService.createPerson(person);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(person2);
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPersons()
	{
		List<Person> allPerson = personService.getAllPerson();
		return ResponseEntity.ok(allPerson);
	}
	
	@GetMapping("/{personId}")
	public ResponseEntity<Person> getPersonById(@PathVariable int personId)
	{
		Person person = personService.getPerson(personId);
		return ResponseEntity.ok(person);
		
	}
	
	@DeleteMapping("/{personId}")
	public ResponseEntity<Person> deletePersonById(@PathVariable int personId)
	{
		personService.deletePerson(personId);
		return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{personId}")
	public ResponseEntity<Person> updatePersonById(@PathVariable int personId
			, @RequestBody Person updatedPerson)
	{
		Person updatePerson = personService.updatePerson(personId, updatedPerson);
		return ResponseEntity.ok(updatePerson);
		
	}

}
