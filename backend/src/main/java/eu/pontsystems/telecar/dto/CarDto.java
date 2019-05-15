package eu.pontsystems.telecar.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
	
	private Long driverId;
	private int maxPlaces;
	private List<PersonDto> passengers;
	private List<RouteDto> routes;
	private boolean isElectric;
	private PersonDto driver;
	private String routeDescription;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy. MM. dd. HH:mm")
    private Date departureDateTime;

}
