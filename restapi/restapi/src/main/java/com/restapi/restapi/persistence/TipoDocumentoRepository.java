package com.restapi.restapi.persistence;


import com.restapi.restapi.domain.TypeDocument;
import com.restapi.restapi.domain.repository.TypeDocumentRepository;
import com.restapi.restapi.persistence.crud.TipoDocumentoCrudRepository;
import com.restapi.restapi.persistence.entity.TipoDocumento;
import com.restapi.restapi.persistence.mapper.TypeDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class TipoDocumentoRepository implements TypeDocumentRepository {

	@Autowired
	private TipoDocumentoCrudRepository tipoDocumentoCrudRepository;
	@Autowired
	private TypeDocumentMapper mapper;
	@Override
	public List<TypeDocument> getAll() {
		List<TipoDocumento> tiposDocumentos = (List<TipoDocumento>) tipoDocumentoCrudRepository.findAll();
		return mapper.toTypeDocuments(tiposDocumentos);
	}

	@Override
	public Optional<TypeDocument> getTypeDocumentById(int id) {
		return tipoDocumentoCrudRepository.findById(id).map(td -> mapper.toTypeDocument(td));
	}

	@Override
	public TypeDocument saveTypeDocument(TypeDocument typeDocument) {
		TipoDocumento tipoDocumento = mapper.toTipoDocumento(typeDocument);
		return mapper.toTypeDocument(tipoDocumentoCrudRepository.save(tipoDocumento));
	}

	@Override
	public void deleteTypeDocumentById(int typeDocumentId) {
		tipoDocumentoCrudRepository.deleteById(typeDocumentId);
		
	}

}
