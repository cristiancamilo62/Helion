package com.helion.domain.model;

public interface GenericValidationRule<T> {
	
	void validate(T data);

}
