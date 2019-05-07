package eu.pontsystems.telecar.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
	
	private String driverName;
	private int maxPlaces;
	private List<RouteDto> routes;
	private String routeDescription;
	
}