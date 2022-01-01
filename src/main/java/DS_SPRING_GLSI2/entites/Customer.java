package DS_SPRING_GLSI2.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name ; 
	private String deliveryadresse ; 
	private String contact ; 
	private boolean active ; 
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

}
