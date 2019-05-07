package eu.pontsystems.telecar.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TELD_CAR")
@NoArgsConstructor
public class Car {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int maxPlaces;
    
    @OneToMany(mappedBy = "cars")
    private List<Person> passengers = new ArrayList<Person>();
    
    @ManyToOne
    @JoinColumn(name = "DRIVER", foreignKey = @ForeignKey(name = "FK_CAR_PERSON"), nullable = false)
    private Person driver;
    
    @OneToMany(mappedBy="car")
    private List<Route> routes = new ArrayList<Route>();
    
    private String routeDescription;
}
