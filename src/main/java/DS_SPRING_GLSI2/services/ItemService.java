package DS_SPRING_GLSI2.services;

import org.springframework.stereotype.Service;

import DS_SPRING_GLSI2.repositories.ItemRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemService {
	public ItemRepository itemRepo;

}
