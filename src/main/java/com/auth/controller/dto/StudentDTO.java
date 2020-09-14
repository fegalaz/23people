package com.auth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	
	private Integer id;
	
	private String rut;
	
	private String name;
	
	private String lastname;
	
	private Integer age;
	
}
