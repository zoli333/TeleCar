package eu.pontsystems.telecar.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.pontsystems.telecar.dto.CarDto;
import eu.pontsystems.telecar.dto.RouteDto;
import eu.pontsystems.telecar.entity.Car;
import eu.pontsystems.telecar.entity.Person;
import eu.pontsystems.telecar.entity.Route;
import eu.pontsystems.telecar.mapper.CarMapper;
import eu.pontsystems.telecar.repository.CarRepository;

@Service
@Transactional
public class CarServiceImpl implements CarService{
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private CarMapper carMapper;
	
	@Override
	public void add(Long driverId, CarDto carDto) {
		Optional<Person> driver = personService.findById(driverId);
		Car car = new Car();
		car.setElectric(carDto.isElectric());
		car.setMaxPlaces(carDto.getMaxPlaces());
		car.setRouteDescription(carDto.getRouteDescription());
		car.setDriver(driver.get());
		car.setDepartureDateTime(carDto.getDepartureDateTime());
		addRoutes(carDto, car);
		
		driver.get().getCars().add(car);
		carRepository.save(car);
	}
	
	private void addRoutes(CarDto carDto, Car car) {
		for (RouteDto r : carDto.getRoutes()) {
			Route route = routeService.findByName(r.getName());
			if (route == null) {
				route = new Route();
				route.setName(r.getName());		
			}
			car.getRoutes().add(route);
		}
	}
	
	public List<Car> findAll() {
		return carRepository.findAll();
	}
}
