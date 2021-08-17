package com.restapi.restapi.domain.service;


import com.restapi.restapi.client.PhotoClient;
import com.restapi.restapi.domain.Customer;
import com.restapi.restapi.domain.Photo;

import com.restapi.restapi.domain.repository.CustomerRepository;

import com.restapi.restapi.error.ServiceCustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PhotoClient photoClient;

	public List<Customer> getAll(){
		List<Customer> customers = customerRepository.getAll();
		if(customers.isEmpty()){
			throw new ServiceCustomerException(HttpStatus.NOT_FOUND,"No existen clientes en la base de datos");
		}
		return customers;
	}
	
	public Customer getCustomer(int customerId){
		Customer customer = customerRepository.getCustomerById(customerId);
		if(customer == null){
			throw new ServiceCustomerException(HttpStatus.NOT_FOUND,"No existen el cliente");
		}

		if(customer.getPhotoId() != null){
			Photo photo = photoClient.buscar(customer.getPhotoId()).getBody();
			customer.setPhoto(photo);
		}

		return customer;
	}
	
	public Optional<List<Customer>> getByTypeDocument(int idTypeDocument){
		return customerRepository.getByTypeDocument(idTypeDocument);
	}
	
	public Customer saveCustomer(Customer customer) throws IOException {
		Customer customer1 = customerRepository.getCustomerById(customer.getCustomerId());
		if(customer1 != null){
			throw new ServiceCustomerException(HttpStatus.BAD_REQUEST," el cliente ya existe");
		}
		Photo photo = null;
		photo = photoClient.registrar(customer.getPhoto()).getBody();
		customer.setPhotoId(photo.getId());
		customer.setPhoto(photo);

		if (customer.getPhoto() == null) {
			throw new ServiceCustomerException(HttpStatus.BAD_REQUEST," el cliente no se puede guardar sin foto");
		}

		customer1 = customerRepository.saveCustomer(customer);
		customer1.setPhoto(photo);
		return  customer1;

	}
	
	public Optional<List<Customer>> getCustomerLessThanEqual(int age){
		return customerRepository.getCustomerLessThanEqual(age);
	}
	public Optional<List<Customer>> getCustomerLessThan(int age){
		return customerRepository.getCustomerLessThan(age);
	}
	public Optional<List<Customer>> getCustomerGreaterThanEqual(int age){
		return customerRepository.getCustomerGreaterThanEqual(age);
	}
	public Optional<List<Customer>> getCustomerGreaterThan(int age){
		return customerRepository.getCustomerGreaterThan(age);
	}
	public void deleteCustomerById(int customerId) {
		Customer customer = customerRepository.getCustomerById(customerId);
		if(customer == null) {
			throw new ServiceCustomerException(HttpStatus.BAD_REQUEST, "El cliente no existe");
		}

		if(customer.getPhotoId() != null){
			photoClient.eliminar(customer.getPhotoId());
		}
		customerRepository.deleteCustomerById(customerId);
		//return getCustomer(customerId).map(cust -> {


			//return true;
		//}).orElse(false);

	}

}
