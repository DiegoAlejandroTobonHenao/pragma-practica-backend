package com.restapi.restapi.persistence.mapper;


import com.restapi.restapi.domain.Customer;
import com.restapi.restapi.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TypeDocumentMapper.class})
public interface CustomerMapper {

	@Mappings({
		@Mapping(source="idCliente",target="customerId"),
		@Mapping(source="nombre",target="name"),
		@Mapping(source="apellidos",target="lastName"),
		@Mapping(source="edad",target="age"),
		@Mapping(source="ciudadNacimiento",target="cityOfTheBirth"),
		@Mapping(source="idTipoDocumento",target="typeDocumentId"),
		@Mapping(source="tipoDocumento",target="typeDocument"),
		@Mapping(source="numeroIdentificacion",target="identificationNumber"),
		@Mapping(source = "fotoId",target = "photoId"),
		@Mapping(target = "photo",ignore = true),
	})
	Customer toCustomer(Cliente cliente);
	
	List<Customer> toCustomers(List<Cliente> clientes);
	
	@InheritInverseConfiguration
	Cliente toCliente(Customer customer);
}
