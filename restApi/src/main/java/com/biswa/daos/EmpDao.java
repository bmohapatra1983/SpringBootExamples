package com.biswa.daos;


import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biswa.entities.Emp;

@Repository
public interface EmpDao extends CrudRepository<Emp, Integer>{
@Query(value="select * from emp where id= ?1",nativeQuery = true)
ArrayList<Emp> getEmployeeData(int id);
}
