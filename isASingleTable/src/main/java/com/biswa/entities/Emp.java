package com.biswa.entities;

import javax.persistence.*;

@DiscriminatorValue(value="2")
@Entity
public class Emp extends Person{

	
	
	private String job;
	private int salary;
	
		
	
	public Emp() {
		super();
		
	}
	public Emp(String name, String job, int salary) {
		super(name);
		this.job = job;
		this.salary = salary;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
}
