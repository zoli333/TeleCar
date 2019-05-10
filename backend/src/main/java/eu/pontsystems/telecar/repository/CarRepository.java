package eu.pontsystems.telecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.pontsystems.telecar.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	
}
