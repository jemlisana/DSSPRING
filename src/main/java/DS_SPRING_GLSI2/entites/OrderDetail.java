package DS_SPRING_GLSI2.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qty ; 
	private float tax ; 
	
	@ManyToOne
	private Order order ; 
	
	@ManyToOne
	private Item item ; 
}
