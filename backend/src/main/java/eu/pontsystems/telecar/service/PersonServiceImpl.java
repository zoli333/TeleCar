package eu.pontsystems.telecar.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.pontsystems.telecar.entity.Person;
import eu.pontsystems.telecar.repository.PersonRepository;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public void save(Optional<Person> person) {
		personRepository.save(person.get());
	}
	
	
	
}
