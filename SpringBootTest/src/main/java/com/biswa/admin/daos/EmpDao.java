package com.biswa.admin.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biswa.admin.entities.Emp;

@Repository
public interface EmpDao extends CrudRepository<Emp, Integer>{
}
