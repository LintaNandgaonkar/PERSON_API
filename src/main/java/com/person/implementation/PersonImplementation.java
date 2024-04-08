package com.person.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.entities.Person;
import com.person.repositories.PersonRepository;
import com.person.services.PersonService;

@Service
public class PersonImplementation implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {
		
		Person save = personRepository.save(person);
		return save;
		
	}

	@Override
	public List<Person> getAllPerson() {
		
		List<Person> allPerson = personRepository.findAll();
		return allPerson;
	}

	@Override
	public Person getPerson(int id) {
		
		 Person personById = personRepository.findById(id)
				 .orElseThrow(()-> new RuntimeException("Person not found"));
		 return personById;
		
	}

	@Override
	public void deletePerson(int id) {
		
		Person personById = personRepository.findById(id)
				 .orElseThrow(()-> new RuntimeException("Person not found"));
		personRepository.delete(personById);
		
		
	}

	@Override
	public Person updatePerson(int id, Person updatedPerson) {
		Person personById = personRepository.findById(id)
				 .orElseThrow(()-> new RuntimeException("Person not found"));
		personById.setName(updatedPerson.getName());
		personById.setCity(updatedPerson.getCity());
		Person save = personRepository.save(personById);
		
		return save;
		
	
	}

}
