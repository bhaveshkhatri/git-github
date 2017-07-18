package com.cb.designpatterns.daopattern;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	
	List<Employee> emps;
	
	public EmployeeDaoImpl() {
	emps = new ArrayList<>();
		
		Employee emp1 = new Employee("Teja", 1);
		Employee emp2 = new Employee("CB", 2);
		Employee emp3 = new Employee("Sravya", 3);
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
	
		return emps;
	}

	@Override
	public Employee getEmp(int empNo) {

		return emps.get(empNo);
	}

	@Override
	public void updateEmp(Employee emp) {
		
		emps.get(emp.getId()).seteName(emp.geteName());
		System.out.println("Employee: Emp ID: "+emp.getId()+" got updated");

	}

	@Override
	public void deleteEmp(Employee emp) {
		
		emps.remove(emp.getId());
		System.out.println("Employee : Emp ID "+emp.getId()+", deleted");

	}

}
