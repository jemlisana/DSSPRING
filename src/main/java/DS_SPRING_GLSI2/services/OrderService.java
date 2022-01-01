package DS_SPRING_GLSI2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import DS_SPRING_GLSI2.entites.Item;
import DS_SPRING_GLSI2.entites.Order;
import DS_SPRING_GLSI2.entites.OrderDetail;
import DS_SPRING_GLSI2.repositories.ItemRepository;
import DS_SPRING_GLSI2.repositories.OrderRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {
	public OrderRepository orderRepo;
	public ItemRepository itemRepo;

	public float calculateTotale(int id) {

		float prixHT = 0;
		float prixTTC = 0;
		float totalPrix = 0;

		Order orderEntity = orderRepo.findById(id).get();

		List<OrderDetail> OrderDetails = orderEntity.getOrdersdetails();

		for (OrderDetail orderDetailsEntity : OrderDetails) {
			Item itemEntity = orderDetailsEntity.getItem();

			prixHT = (itemEntity.getPrice() * orderDetailsEntity.getQty());
			prixTTC = prixHT + (prixHT * orderDetailsEntity.getTax());
			totalPrix = totalPrix + prixTTC;
		}

		return totalPrix;
	}

	public float calculateWeight(int id) {
		// TODO Auto-generated method stub
		float total = 0;
		float poids = 0 ;
		Order orderEntity = orderRepo.findById(id).get();

		List<OrderDetail> OrderDetails = orderEntity.getOrdersdetails();

		for (OrderDetail orderDetailsEntity : OrderDetails) {
			Item itemEntity = orderDetailsEntity.getItem();

			poids = (itemEntity.getWeight() * orderDetailsEntity.getQty());
			total = total + poids;
		}

		return total;
	}

}
