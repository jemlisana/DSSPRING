package DS_SPRING_GLSI2.entites;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String deliveryman ; 
	private LocalDate shoppingdate ; 
	private LocalDate deliverydate ; 
	
	@ManyToOne
	private Order order ; 
}
