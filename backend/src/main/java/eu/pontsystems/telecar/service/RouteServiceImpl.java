package eu.pontsystems.telecar.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.pontsystems.telecar.entity.Route;
import eu.pontsystems.telecar.repository.RouteRepository;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;
	
	@Override
	public Route findByName(String name) {
		return routeRepository.findByName(name);
	}
	
	
}
