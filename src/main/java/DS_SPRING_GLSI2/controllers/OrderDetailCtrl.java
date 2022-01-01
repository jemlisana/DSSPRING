package DS_SPRING_GLSI2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DS_SPRING_GLSI2.services.OrderDetailService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/orderdetails")
@AllArgsConstructor
public class OrderDetailCtrl {
	public OrderDetailService orderDetailService;
}
