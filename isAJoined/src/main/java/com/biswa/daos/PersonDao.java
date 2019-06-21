package com.biswa.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biswa.entities.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer>{

}
