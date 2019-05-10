package eu.pontsystems.telecar.service;

import eu.pontsystems.telecar.dto.CarDto;
import eu.pontsystems.telecar.entity.Car;

public interface CarService {
	
	public void add(Long driverId, CarDto carDto); 
	
}
