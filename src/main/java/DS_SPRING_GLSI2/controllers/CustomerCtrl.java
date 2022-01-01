package DS_SPRING_GLSI2.controllers;


import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DS_SPRING_GLSI2.entites.Customer;
import DS_SPRING_GLSI2.entites.CustomerDTO;
import DS_SPRING_GLSI2.services.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerCtrl {
	public CustomerService cusService;
	@PostMapping("/add")
	
	public Customer saveCustomer(@RequestBody Customer customerEnitity)
	{
		System.out.println(customerEnitity);
		return cusService.saveTODB(customerEnitity);
	}
	
	@GetMapping("/get")
	public List<Customer> getAllCus()
	{
		return cusService.getAllCustomer();
	}
	
	@GetMapping("/get/{id}")
	public Customer getOneCus(@PathVariable("id") int id)
	{
		return cusService.getCusByID(id);
	}
	@GetMapping("/get/CustomerPlusCinqCommande")
	public List<CustomerDTO> CustomerPlusCinqCommande() {
		return cusService.CustomerPlusCinqCommande();
	}

	@GetMapping("/get/CustomerPlusCinqDepense")
	public List<CustomerDTO> CustomerPlusCinqDepense() {
		return cusService.CustomerPlusCinqDepense();
	}

	@GetMapping("/get/CustomerOrderPlusPoids/{deb}/{fin}")
	public List<CustomerDTO> CustomerOrderPlusPoids(@PathVariable String deb,@PathVariable String fin) {
		LocalDate debDate = LocalDate.parse(deb);
		LocalDate finDate = LocalDate.parse(fin);
		return cusService.CustomerOrderPlusPoids(debDate, finDate);
	}	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNSEE(NoSuchElementException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body("Error in serach : " + e.getMessage());
	}
	
	@PutMapping("/update/{id}")
	public Customer getOneEmp(@PathVariable("id") int id,@RequestBody Customer newCustomer )
	{
		return cusService.updateCusId(id,newCustomer);
	}
	
	@DeleteMapping("/delete/{id}")
	public Customer deleteOneEmp(@PathVariable("id") int id)
	{
		return cusService.deleteById(id);
	}
}
