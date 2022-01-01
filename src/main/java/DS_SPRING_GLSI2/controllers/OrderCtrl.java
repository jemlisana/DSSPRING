package DS_SPRING_GLSI2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DS_SPRING_GLSI2.entites.Delivery;
import DS_SPRING_GLSI2.services.OrderService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderCtrl {
	public OrderService orderService;

	@GetMapping("/total/{id}")
	public float getTotale(@PathVariable("id") int id) {
		return orderService.calculateTotale(id);
	}

	@GetMapping("/weight/{id}")
	public float getWeight(@PathVariable("id") int id) {
		return orderService.calculateWeight(id);
	}

	@GetMapping("/get/livreurRapide")
	public Delivery livreurPlusRapide() {

		return orderService.livreursPlusRapide();
	}

	@GetMapping("/get/livreurLente")
	public Delivery livreurPlusLente() {

		return orderService.livreurPlusLente();
	}
}
