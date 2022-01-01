package DS_SPRING_GLSI2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import DS_SPRING_GLSI2.entites.Delivery;
import DS_SPRING_GLSI2.services.DeliveryService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/deliverys")
@AllArgsConstructor
public class DeliveryCtrl {
	public DeliveryService deliveryService;
	
	@GetMapping("/get/livreurRapide")
	public Delivery livreurPlusRapide() {
		
		return deliveryService.livreursPlusRapide();
	}
	
	@GetMapping("/get/livreurLente")
	public Delivery livreurPlusLente() { 
		
		return deliveryService.livreurPlusLente();
	}
}
