package com.restapi.restapi.domain.repository;



import com.restapi.restapi.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

	List<Customer> getAll();
	Optional<List<Customer>> getByTypeDocument(int idTypeDocument);
	Customer getCustomerById(int id);
	Customer saveCustomer(Customer customer);
	Optional<List<Customer>> getCustomerLessThanEqual(int age);
	Optional<List<Customer>> getCustomerLessThan(int age);
	Optional<List<Customer>> getCustomerGreaterThanEqual(int age);
	Optional<List<Customer>> getCustomerGreaterThan(int age);
	void deleteCustomerById(int customerId);
}
