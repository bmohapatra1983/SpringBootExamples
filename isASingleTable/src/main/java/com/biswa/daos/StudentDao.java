package com.biswa.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biswa.entities.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer>{

}
