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
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private float weight ; 
	private String description;
	private float price  ; 
	
	@OneToMany(mappedBy = "item")
	private List<OrderDetail> ordersdetails;
	
}
