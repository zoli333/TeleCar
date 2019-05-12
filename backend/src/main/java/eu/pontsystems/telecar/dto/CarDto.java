package eu.pontsystems.telecar.dto;

import java.util.List;

import lombok.Data;

@Data
public class CarDto {
	
	private Long driverId;
	private int maxPlaces;
	private List<PersonDto> passengers;
	private List<RouteDto> routes;
	private boolean isElectric;
	private PersonDto driver;
	private String routeDescription;
	
}
