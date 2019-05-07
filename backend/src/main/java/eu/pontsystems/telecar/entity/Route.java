package eu.pontsystems.telecar.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TELD_ROUTE")
@NoArgsConstructor
public class Route {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String route;
	
    @ManyToOne
    @JoinColumn(name = "CAR", foreignKey = @ForeignKey(name = "FK_ROUTE_CAR"), nullable = false)
    private Car car;
	
}
