package DS_SPRING_GLSI2.entites;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Table(name = "order_table")
@Entity
@Data

public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate createdate ;
	
	@Enumerated (EnumType.ORDINAL) // pour stocker enum en indice 
	private OrderStatus orderstatut;
	
	@ManyToOne
	private Customer customer ; 
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> ordersdetails;
	
	@OneToMany(mappedBy = "order")
	private List<Delivery> delivery;
}
