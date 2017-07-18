package com.cb.designpatterns.daopattern;

import java.util.List;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	public Employee getEmp(int empNo);
	public void updateEmp(Employee emp);
	public void deleteEmp(Employee emp);

}
