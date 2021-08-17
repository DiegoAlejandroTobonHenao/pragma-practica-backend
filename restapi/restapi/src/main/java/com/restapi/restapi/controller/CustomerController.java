package com.restapi.restapi.controller;


import com.restapi.restapi.domain.Customer;
import com.restapi.restapi.domain.Photo;
import com.restapi.restapi.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@GetMapping("/Saludar")
	public Customer saludar() {

		Customer customer = new Customer();
		customer.setAge(20);
		customer.setCustomerId(01);
		customer.setLastName("Tobon");
		customer.setName("diego");
		customer.setTypeDocumentId(1);
		customer.setIdentificationNumber("11111");
		customer.setCityOfTheBirth("Manizales");

		Photo photo = new Photo();
		photo.setContenido(null);
		photo.setTipoContenido("Imagen");
		photo.setNombre("imagen");
		photo.setId("01");

		customer.setPhotoId(photo.getId());
		customer.setPhoto(photo);
		return customer;
	}
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAll(){
		return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") int customerId){
		return new ResponseEntity<>(customerService.getCustomer(customerId),HttpStatus.OK);
				//orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/typeDocument/{idTypeDocument}")
	public ResponseEntity<List<Customer>> getByTypeDocument(@PathVariable("idTypeDocument") int idTypeDocument){
		return customerService.getByTypeDocument(idTypeDocument)
				.map(cust -> new ResponseEntity<>(cust, HttpStatus.OK)).
				orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) throws IOException {

		return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);

	}
	
	@GetMapping("/lessThanEqual/{age}")
	public Optional<List<Customer>> getCustomerLessThanEqual(@PathVariable("age") int age){
		return customerService.getCustomerLessThanEqual(age);
	}
	
	@GetMapping("/lessThan/{age}")
	public Optional<List<Customer>> getCustomerLessThan(@PathVariable("age") int age){
		return customerService.getCustomerLessThan(age);
	}
	
	@GetMapping("/greaterThanEqual/{age}")
	public Optional<List<Customer>> getCustomerGreaterThanEqual(@PathVariable("age") int age){
		return customerService.getCustomerGreaterThanEqual(age);
	}
	
	@GetMapping("/greaterThan/{age}")
	public Optional<List<Customer>> getCustomerGreaterThan(@PathVariable("age") int age){
		return customerService.getCustomerGreaterThan(age);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteCustomerById(@PathVariable("id") int customerId) {
		//if(customerService.deleteCustomerById(customerId)) {
			customerService.deleteCustomerById(customerId);
			return new ResponseEntity( HttpStatus.OK);
		//}else {
		//	return new ResponseEntity(HttpStatus.NOT_FOUND);
	//}
		
	}
}
