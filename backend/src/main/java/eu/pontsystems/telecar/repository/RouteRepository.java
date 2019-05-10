package eu.pontsystems.telecar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.pontsystems.telecar.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long>{

	public Route findByName(String name);
	
}
