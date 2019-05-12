package eu.pontsystems.telecar.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.pontsystems.telecar.dto.CarDto;
import eu.pontsystems.telecar.entity.Car;
import eu.pontsystems.telecar.entity.Person;
import eu.pontsystems.telecar.service.CarService;
import ma.glasnost.orika.MapperFacade;

@Transactional
@Component
public class CarMapper {

	@Autowired
	private CarService carService;
	
	@Autowired
	private MapperFacade mapper;
	
	public List<CarDto> findAll() {
		List<Car> cars = carService.findAll();
		List<CarDto> carDtos = new ArrayList<CarDto>();
		for (Car car : cars) {
			filterOutDriverFromPassengers(car, carDtos);
		}
		return carDtos;
	}
	
	private void filterOutDriverFromPassengers(Car car, List<CarDto> carDtos) {
		Person driver = car.getDriver();
		car.setPassengers(car.getPassengers()
			.stream()
			.filter(passenger -> !passenger.getId().equals(driver.getId()))
			.collect(Collectors.toList()));
		carDtos.add(mapper.map(car, CarDto.class));
	}
	
}
