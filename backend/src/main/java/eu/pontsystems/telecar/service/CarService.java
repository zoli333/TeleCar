package eu.pontsystems.telecar.service;

import eu.pontsystems.telecar.dto.CarDto;

public interface CarService {
	
	public void add(Long driverId, CarDto carDto); 
	
}
