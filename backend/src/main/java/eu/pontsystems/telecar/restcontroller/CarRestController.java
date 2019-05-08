package eu.pontsystems.telecar.restcontroller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.pontsystems.telecar.dto.CarDto;

@RestController
@RequestMapping("/api/cars")
public class CarRestController {

	@PostMapping("/{id}/add")
	public void add(@PathVariable("id") Long driverId, @RequestBody CarDto carDto) {
		System.out.println(driverId);
		System.out.println(carDto);
	}
	
	
}
