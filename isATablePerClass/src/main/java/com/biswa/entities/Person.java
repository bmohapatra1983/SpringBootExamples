package com.biswa.entities;
/*
 Author : Biswaranjan Mohapatra
 */
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name="Person1")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@GenericGenerator(name="g1",strategy="increment")
public class Person {
	@Id
	@GeneratedValue(generator="g1")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	
	public Person() {
		super();
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
