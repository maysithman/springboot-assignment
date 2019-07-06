package com.techfun.assign_two.model;

import javax.validation.constraints.Max;

import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Employee {

	private Integer id;
	
	@NotBlank(message = "Name cannot be null")
	//@NotNull(message = "Name cannot be null")
	private String name;
	
	@Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
	private Integer age;
	
	private String city;
	
	@Email(message = "Email should be valid")
	private String email;

	public Employee() {
		super();
	}

	public Employee(String name, Integer age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public Employee(String name, Integer age, String city, String email) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.email = email;
	}

	public Employee(Integer id, String name, Integer age, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
