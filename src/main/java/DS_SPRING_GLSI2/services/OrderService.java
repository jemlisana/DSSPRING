package DS_SPRING_GLSI2.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import DS_SPRING_GLSI2.entites.Delivery;
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

// calculateTotal() qui calcule le total d’ordre inclut le taxe. 
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

// calculateTotal() qui calcule le total d’ordre inclut le taxe. 
	public float calculateWeight(int id) {
		// TODO Auto-generated method stub
		float total = 0;
		float poids = 0;
		Order orderEntity = orderRepo.findById(id).get();

		List<OrderDetail> OrderDetails = orderEntity.getOrdersdetails();

		for (OrderDetail orderDetailsEntity : OrderDetails) {
			Item itemEntity = orderDetailsEntity.getItem();

			poids = (itemEntity.getWeight() * orderDetailsEntity.getQty());
			total = total + poids;
		}

		return total;
	}

//. Afficher le livreur qui a une moyenne de temps de livraison la plus rapide. 
	public Delivery livreursPlusRapide() {
		List<Order> orders = orderRepo.findAll();
		int min = -1;
		Delivery delivery = null;

		for (Order orderEntity : orders) {
			LocalDate dat_cre = orderEntity.getCreatedate();

			for (Delivery deliveryEntity : orderEntity.getDelivery()) {
				LocalDate dat_delivery = deliveryEntity.getDeliverydate();
				if (ChronoUnit.DAYS.between(dat_delivery, dat_cre) < min) {
					min = (int) ChronoUnit.DAYS.between(dat_delivery, dat_cre);
					delivery = deliveryEntity;
				}
			}
		}

		return delivery;

	}

	// . Afficher le livreur qui a une moyenne de temps de livraison la plus lente.
	public Delivery livreurPlusLente() {
		List<Order> orders = orderRepo.findAll();
		int max = -1;
		Delivery delivery = null;

		for (Order orderEntity : orders) {
			LocalDate dat_cre = orderEntity.getCreatedate();

			for (Delivery deliveryEntity : orderEntity.getDelivery()) {
				LocalDate dat_delivery = deliveryEntity.getDeliverydate();
				if (ChronoUnit.DAYS.between(dat_delivery, dat_cre) > max) {
					max = (int) ChronoUnit.DAYS.between(dat_delivery, dat_cre);
					delivery = deliveryEntity;
				}
			}
		}

		return delivery;

	}
}
