package eu.pontsystems.telecar.service;

import java.util.Optional;

import eu.pontsystems.telecar.entity.Person;

public interface PersonService {
	
	public Optional<Person> findById(Long id);
	
	public void save(Optional<Person> person);
	
}
