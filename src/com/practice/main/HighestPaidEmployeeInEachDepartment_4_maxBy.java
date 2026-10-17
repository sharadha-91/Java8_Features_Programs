package com.practice.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.practice.streams.Employee;

public class HighestPaidEmployeeInEachDepartment_4_maxBy {

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

 
	  Map<String, Optional<Employee>> result = employees.stream()
			    .collect(Collectors.groupingBy(
			        Employee::getDepartment,
			        Collectors.maxBy(
			            Comparator.comparingDouble(Employee::getSalary)
			        )
			    ));
      
	  
	  result.forEach((department, optionalEmployee) ->
	    optionalEmployee.ifPresent(employee ->
	        System.out.println(department + " -> " + employee)
	    )
	);
	  
	  
}     
}
