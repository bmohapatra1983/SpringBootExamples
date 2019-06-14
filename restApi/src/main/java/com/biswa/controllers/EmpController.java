package com.biswa.controllers;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biswa.daos.EmpDao;
import com.biswa.entities.Emp;

@RestController
public class EmpController {

	@Autowired
	EmpDao dao;

	// Method to save Emp
	// @PostMapping(value="/",consumes={"application/json"})
	@RequestMapping("/employees")
	// @PutMapping(value="/employees",consumes={"application/json"})
	public String save() {
		Emp e = new Emp();
		e.setName("OM Prakash");
		e.setJob("GM EPS");
		e.setSalary(2323);
		dao.save(e);
		return "saved";
	}

	// Method to return all Employees
	@GetMapping(value = "/all", produces = { "application/json" })
	public Iterable<Emp> getAll() {
		return dao.findAll();
	}

	// Method to return an Emp using id
	@GetMapping(value = "/{id}", produces = { "application/json" })
	public Emp getById(@PathVariable int id) {
		Emp e = null;
		Optional<Emp> op = dao.findById(id);
		if (op.isPresent())
			e = op.get();
		return e;
	}
}
