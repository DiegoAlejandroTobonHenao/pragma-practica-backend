package com.restapi.restapi.domain;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@NoArgsConstructor
public class Customer {

	private int customerId;
	private String name;
	private String lastName;

	@Positive
	@Min(0)
	@Max(150)
	private int age;

	private String cityOfTheBirth;
	private int typeDocumentId;
	private String identificationNumber;
	private String photoId;
	private Photo photo;
	private TypeDocument typeDocument;


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCityOfTheBirth() {
		return cityOfTheBirth;
	}
	public void setCityOfTheBirth(String cityOfTheBirth) {
		this.cityOfTheBirth = cityOfTheBirth;
	}
	public int getTypeDocumentId() {
		return typeDocumentId;
	}
	public void setTypeDocumentId(int typeDocumentId) {
		this.typeDocumentId = typeDocumentId;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Photo getPhoto() {
		return photo;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
}
