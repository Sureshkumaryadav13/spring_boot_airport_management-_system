package com.flight.airportmanagementsystem.respose;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApplicationResponse<T>{
	
	private int statusCode;
	private String message;
	private String description;
	private T data;

}
