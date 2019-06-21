package com.biswa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@RequestMapping("/addEmployee")
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
	// Method to test the angular fetch call.
	@CrossOrigin(origins = "http://localhost:4200") // @CrossOrigin is used to handle the request from a difference
													// origin.
	@GetMapping(value = "/getemployees", produces = { "application/json" })
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

	// Method to delete an Emp using id
	@DeleteMapping(value = "/{id}")
	public String remove(@PathVariable int id) {
		dao.deleteById(id);
		return "deleted";
	}
}
