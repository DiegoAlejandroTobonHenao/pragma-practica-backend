package com.restapi.restapi.domain.service;


import com.restapi.restapi.domain.TypeDocument;
import com.restapi.restapi.domain.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDocumentService {
	@Autowired
	private TypeDocumentRepository typeDocumentRepository;

	public List<TypeDocument> getAll(){
		return typeDocumentRepository.getAll();
	}
	
	public Optional<TypeDocument> getTypeDocument(int typeDocumentId){
		return typeDocumentRepository.getTypeDocumentById(typeDocumentId);
	}
	
	public TypeDocument saveTypeDocument(TypeDocument typeDocument) {
		return typeDocumentRepository.saveTypeDocument(typeDocument);
	}
	
	public boolean deleteTypeDocumentById(int typeDocumentId) {
		return getTypeDocument(typeDocumentId).map(td -> {
			typeDocumentRepository.deleteTypeDocumentById(typeDocumentId);
			return true;
		}).orElse(false);
	}
	
	
}
