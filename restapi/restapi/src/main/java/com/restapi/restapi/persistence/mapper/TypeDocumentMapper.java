package com.restapi.restapi.persistence.mapper;


import com.restapi.restapi.domain.TypeDocument;
import com.restapi.restapi.persistence.entity.TipoDocumento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeDocumentMapper {
	@Mappings({
		@Mapping(source="idTipoDocumento",target="idTypeDocument"),
		@Mapping(source="nombre",target="name")
	})
	TypeDocument toTypeDocument(TipoDocumento tipoDocumento);
	
	List<TypeDocument> toTypeDocuments(List<TipoDocumento> tipoDocumento);
	
	@InheritInverseConfiguration
	@Mapping(target = "clientes",ignore = true)
	TipoDocumento toTipoDocumento(TypeDocument typeDocument);
}
