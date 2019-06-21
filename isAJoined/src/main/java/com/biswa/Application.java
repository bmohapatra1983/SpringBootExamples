package com.biswa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.biswa.daos.*;
import com.biswa.entities.Emp;
import com.biswa.entities.Person;
import com.biswa.entities.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(Application.class, args);
		PersonDao pdao=(PersonDao)ctx.getBean("personDao");
		EmpDao edao=(EmpDao)ctx.getBean("empDao");
		StudentDao sdao=(StudentDao)ctx.getBean("studentDao");
		System.out.println("Saving objects of Person family...");
		Person p=new Person("Biswaranjan");
		Emp e=new Emp("Kapil","Accountant",26000);
		Student s=new Student("OM Prakash","Java",15000);
		
		pdao.save(p);
		edao.save(e);
		sdao.save(s);
		System.out.println("Successfully saved.");
		System.out.println("Fetching all Persons...");
		Iterable<Person> itr=pdao.findAll();
		System.out.println("Following persons are found...");
		for(Person person : itr)
			{
			 if(person instanceof Student)
			 {
				 Student st=(Student)person;
				 System.out.println(st.getName()+"\t"+
				 st.getCourse()+"\t"+st.getFee()); 
			
			 }
			 else if(person instanceof Emp)
			 {
				 Emp emp=(Emp)person;
				 System.out.println(emp.getName()+"\t"+
				 emp.getJob()+"\t"+emp.getSalary());
			 }
			 else
			 {
				 System.out.println(person.getName());
			 }
			}
			
	}

}
