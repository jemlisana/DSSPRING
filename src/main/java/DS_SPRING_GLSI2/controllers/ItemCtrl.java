package DS_SPRING_GLSI2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DS_SPRING_GLSI2.services.ItemService;
import lombok.AllArgsConstructor;

@RestController   
@RequestMapping("/api/items")
@AllArgsConstructor
public class ItemCtrl {
	public ItemService itemService ; 
}
