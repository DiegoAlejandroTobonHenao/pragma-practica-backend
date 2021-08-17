package com.restapi.restapi.persistence;


import com.restapi.restapi.domain.Customer;
import com.restapi.restapi.domain.repository.CustomerRepository;
import com.restapi.restapi.persistence.crud.ClienteCrudRepository;
import com.restapi.restapi.persistence.entity.Cliente;
import com.restapi.restapi.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ClienteRepository implements CustomerRepository {
	
	@Autowired
	private ClienteCrudRepository clienteCrudRepository;
	
	@Autowired
	private CustomerMapper mapper;
	
	@Override
	public List<Customer> getAll() {
		List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
		return mapper.toCustomers(clientes);
	}

	@Override
	public Optional<List<Customer>> getByTypeDocument(int idTypeDocument) {
		List<Cliente> clientes = clienteCrudRepository.findByIdTipoDocumentoOrderByEdadAsc(idTypeDocument);
		return Optional.of(mapper.toCustomers(clientes));
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer1 = mapper.toCustomer(clienteCrudRepository.findById(id).orElse(null));
		return customer1;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		Cliente cliente = mapper.toCliente(customer);
		return mapper.toCustomer(clienteCrudRepository.save(cliente));
	}

	@Override
	public Optional<List<Customer>> getCustomerLessThanEqual(int age) {
		Optional<List<Cliente>> clientes = clienteCrudRepository.findByEdadLessThanEqualOrderByEdadAsc(age);
		return clientes.map(c -> mapper.toCustomers(c));
	}

	@Override
	public Optional<List<Customer>> getCustomerLessThan(int age) {
		Optional<List<Cliente>> clientes = clienteCrudRepository.findByEdadLessThanOrderByEdadAsc(age);
		return clientes.map(c -> mapper.toCustomers(c));
	}

	@Override
	public Optional<List<Customer>> getCustomerGreaterThanEqual(int age) {
		Optional<List<Cliente>> clientes = clienteCrudRepository.findByEdadGreaterThanEqualOrderByEdadAsc(age);
		return clientes.map(c -> mapper.toCustomers(c));
	}

	@Override
	public Optional<List<Customer>> getCustomerGreaterThan(int age) {
		Optional<List<Cliente>> clientes = clienteCrudRepository.findByEdadGreaterThanOrderByEdadAsc(age);
		return clientes.map(c -> mapper.toCustomers(c));
	}

	@Override
	public void deleteCustomerById(int customerId) {
		clienteCrudRepository.deleteById(customerId);
	}

	
	
}
