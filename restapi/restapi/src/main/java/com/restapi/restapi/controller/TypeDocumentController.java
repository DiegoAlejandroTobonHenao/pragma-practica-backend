package com.restapi.restapi.controller;



import com.restapi.restapi.domain.TypeDocument;
import com.restapi.restapi.domain.service.TypeDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeDocument")
public class TypeDocumentController {
	@Autowired
	private TypeDocumentService typeDocumentService;
	
	@GetMapping("/all")
	public ResponseEntity<List<TypeDocument>> getAll(){
		return new ResponseEntity<>(typeDocumentService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{typeDocumentId}")
	public ResponseEntity<TypeDocument> getTypeDocumentById(@PathVariable("typeDocumentId") int typeDocumentId){
		return typeDocumentService.getTypeDocument(typeDocumentId)
				.map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
				orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteTypeDocumentById(@PathVariable("id") int typeDocumentId) {
		if( typeDocumentService.deleteTypeDocumentById(typeDocumentId)) {
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}

	@PostMapping("/save")
	public ResponseEntity<TypeDocument> saveCustomer(@RequestBody TypeDocument typeDocument) {
		return new ResponseEntity<>(typeDocumentService.saveTypeDocument(typeDocument),HttpStatus.CREATED);
	}
	
	
}
