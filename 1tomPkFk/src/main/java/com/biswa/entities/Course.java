package com.biswa.entities;

import java.util.Set;

import javax.persistence.*;

//Owner entity class
@Entity
@Table(name="CourseMaster")
public class Course {

	
	//state
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int fee;
	
	//relation
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="courseId")
	Set<Topic> topics;

	//behavior	
	public Course() {
		super();
	}

	public Course(String name, int fee, Set<Topic> topics) {
		super();
		this.name = name;
		this.fee = fee;
		this.topics = topics;
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

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
	
	
}
