package com.biswa.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biswa.entities.*;

@Repository
public interface CourseDao extends 
		CrudRepository<Course, Integer>{

}
