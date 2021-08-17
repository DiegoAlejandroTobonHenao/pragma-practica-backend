package com.restapi.restapi.persistence.crud;


import com.restapi.restapi.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {

	List<Cliente> findByIdTipoDocumentoOrderByEdadAsc(int idTipoDocumento);
	
	Optional<List<Cliente>> findByEdadGreaterThanOrderByEdadAsc(int edad);
	Optional<List<Cliente>> findByEdadLessThanOrderByEdadAsc(int edad);
	Optional<List<Cliente>> findByEdadGreaterThanEqualOrderByEdadAsc(int edad);
	Optional<List<Cliente>> findByEdadLessThanEqualOrderByEdadAsc(int edad);
}
