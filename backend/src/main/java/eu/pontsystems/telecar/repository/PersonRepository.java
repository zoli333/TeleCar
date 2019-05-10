package eu.pontsystems.telecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.pontsystems.telecar.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
