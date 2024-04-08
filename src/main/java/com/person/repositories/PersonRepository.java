package com.person.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.person.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	//write custom methods here

}
