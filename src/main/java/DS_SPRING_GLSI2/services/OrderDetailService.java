package DS_SPRING_GLSI2.services;

import org.springframework.stereotype.Service;

import DS_SPRING_GLSI2.repositories.OrderDetailRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderDetailService {
public OrderDetailRepository OrderDetailRepo;
}
