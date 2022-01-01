package DS_SPRING_GLSI2.entites;

import java.util.Comparator;
import java.util.List;


import DS_SPRING_GLSI2.services.OrderService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class CustomerDepenseComparator implements Comparator<Customer> {
	public OrderService orderSer;
	// override the compare() method
	public int compare(Customer s1, Customer s2) {
		float sumDepenseS1=0;
		float sumDepenseS2=0;
		
		List<Order> orders1 = s1.getOrders();
		
		for (Order ordersEntity : orders1) {
			sumDepenseS1=sumDepenseS1+ orderSer.calculateTotale(ordersEntity.getId()) ;
		}
		List<Order> orders2 = s2.getOrders();
		
		for (Order ordersEntity : orders2) {
			sumDepenseS2=sumDepenseS2+ orderSer.calculateTotale(ordersEntity.getId()) ;
		}
		if ( sumDepenseS1== sumDepenseS2)
			return 0;
		else if (sumDepenseS1 < sumDepenseS2)
			return 1;
		else
			return -1;
	}
}
