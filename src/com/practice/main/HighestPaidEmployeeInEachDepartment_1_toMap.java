package com.practice.main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.practice.streams.Employee;

public class HighestPaidEmployeeInEachDepartment_1_toMap {
	
	 public static void main(String[] args) {

	        List<Employee> employees = Arrays.asList(
	        	    new Employee("Ravi",   "IT",      80000),
	        	    new Employee("Priya",  "HR",      60000),
	        	    new Employee("Arjun",  "IT",     100000),
	        	    new Employee("Sneha",  "HR",      75000),
	        	    new Employee("Kiran",  "Finance", 90000),
	        	    new Employee("Meena",  "IT",      95000),
	        	    new Employee("Rahul",  "Finance", 85000),
	        	    new Employee("Divya",  "HR",      70000)
	        );

	        Map<String, Employee> map = employees.stream()
	            .collect(Collectors.toMap(
	                Employee::getDepartment,
	                Function.identity(),
	                (e1, e2) ->
	                    e1.getSalary() >= e2.getSalary() ? e1 : e2
	            ));

	        map.forEach((department, employee) ->
	            System.out.println(
	                department + " -> " + employee.getName()
	                    + ", Salary: " + employee.getSalary()
	            )
	        );
	    }

}
