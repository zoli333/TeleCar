package eu.pontsystems.telecar.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.pontsystems.telecar.dto.CarDto;
import eu.pontsystems.telecar.entity.Car;
import eu.pontsystems.telecar.mapper.CarMapper;
import eu.pontsystems.telecar.service.CarService;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private CarMapper carMapper;
	
	@PostMapping("/{id}/add")
	public void add(@PathVariable("id") Long driverId, @RequestBody CarDto carDto) {
		carService.add(driverId, carDto);
	}
	
	@GetMapping
	public List<CarDto> cars() {
		return carMapper.findAll();
	}
	
}
