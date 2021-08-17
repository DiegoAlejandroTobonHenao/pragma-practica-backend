package com.restapi.restapi.domain.repository;



import com.restapi.restapi.domain.TypeDocument;

import java.util.List;
import java.util.Optional;

public interface TypeDocumentRepository {
	List<TypeDocument> getAll();
	Optional<TypeDocument> getTypeDocumentById(int id);
	TypeDocument saveTypeDocument(TypeDocument typeDocument);
	void deleteTypeDocumentById(int typeDocumentId);

}
