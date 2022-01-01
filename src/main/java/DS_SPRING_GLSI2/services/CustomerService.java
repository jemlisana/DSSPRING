package DS_SPRING_GLSI2.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import DS_SPRING_GLSI2.entites.Customer;
import DS_SPRING_GLSI2.entites.CustomerDTO;
import DS_SPRING_GLSI2.entites.CustomerDepenseComparator;
import DS_SPRING_GLSI2.entites.CustomerOrderComparator;
import DS_SPRING_GLSI2.entites.Order;
import DS_SPRING_GLSI2.repositories.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	public CustomerRepository custRepo;
	public OrderService orderSer;
	ModelMapper mapper;

	// ramener les 5 tops clients selon le nombre de commandes.
	public List<CustomerDTO> CustomerPlusCinqCommande() {

		List<CustomerDTO> customerFidele = new ArrayList<>();
		List<Customer> customerEntity = custRepo.findAll();
		Collections.sort(customerEntity, new CustomerOrderComparator());
		int i = 0;
		for (Customer CustomerEntity : customerEntity) {
			if (i == 5) {
				break;
			}
			CustomerDTO customerDTO = mapper.map(CustomerEntity, CustomerDTO.class);
			customerFidele.add(customerDTO);
			i++;
		}
		return customerFidele;
	}

	// . Afficher les 5 tops clients selon le montant d'argent dépensé.
	public List<CustomerDTO> CustomerPlusCinqDepense() {
		List<CustomerDTO> customerFidele = new ArrayList<>();
		List<Customer> customerEntity = custRepo.findAll();
		Collections.sort(customerEntity, new CustomerDepenseComparator(orderSer));
		int i = 0;
		for (Customer CustomerEntity : customerEntity) {
			if (i == 5) {
				break;
			}
			CustomerDTO customerDTO = mapper.map(CustomerEntity, CustomerDTO.class);
			customerFidele.add(customerDTO);
			i++;
		}
		return customerFidele;
	}

	// les clients qui ont demandé des ordres dont dépassent le 10 kg dans une
	// période donnée.
	public List<CustomerDTO> CustomerOrderPlusPoids(LocalDate dateDebut, LocalDate dateFin) {
		// TODO Auto-generated method stub
		List<CustomerDTO> customerFidele = new ArrayList<>();
		List<Customer> customerEntity = custRepo.findAll();
		float sumPoidsS1 = 0;

		for (Customer CustomerEntity : customerEntity) {

			List<Order> orders1 = CustomerEntity.getOrders();
			if (orders1.size() != 0) {
				for (Order ordersEntity : orders1) {
					if (ordersEntity.getCreatedate().isBefore(dateDebut)
							|| ordersEntity.getCreatedate().isBefore(dateFin))
						sumPoidsS1 = sumPoidsS1 + orderSer.calculateWeight(ordersEntity.getId());
				}
				if (sumPoidsS1 > 10000) {
					CustomerDTO customerDTO = mapper.map(CustomerEntity, CustomerDTO.class);
					customerFidele.add(customerDTO);
				}
			}
		}
		return customerFidele;
	}

	// enregistrer Customer
	public Customer saveTODB(Customer customerEnitity) {
		custRepo.save(customerEnitity);
		return customerEnitity;
	}

	// ramener tt les Customers
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return custRepo.findAll();
	}

	// ramener Customer avec ID
	public Customer getCusByID(int id) {
		Optional<Customer> opt = custRepo.findById(id);
		return opt.orElseThrow(() -> new NoSuchElementException("Customer with id is not found"));
	}

	// update
	public Customer updateCusId(int id, Customer newCustomer) {
		Customer entity = getCusByID(id);
		if (newCustomer.getName() != null)
			entity.setName(newCustomer.getName());
		if (newCustomer.getDeliveryadresse() != null)
			entity.setDeliveryadresse(newCustomer.getDeliveryadresse());
		if (newCustomer.getContact() != null)
			entity.setContact(newCustomer.getContact());
		if (newCustomer.isActive() != newCustomer.isActive())
			entity.setActive(newCustomer.isActive());
		return custRepo.save(entity);
	}

	// delete
	public Customer deleteById(int id) {
		Customer entity = getCusByID(id);
		custRepo.deleteById(id);
		return entity;
	}

}