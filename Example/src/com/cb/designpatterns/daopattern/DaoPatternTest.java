package com.cb.designpatterns.daopattern;

public class DaoPatternTest {
	
	public static void main(String[] args) {
	
		EmployeeDao empDao = new EmployeeDaoImpl();
		
		for(Employee emp: empDao.getAllEmployees()) {
		
			System.out.println("Employee: {EmpId : "+emp.getId()+", EmpName : "+emp.geteName());
		}
		
		System.out.println("\n\n\n");
		
		Employee emp = empDao.getEmp(0);
		emp.seteName("Chinna");
		empDao.updateEmp(emp);
		
		for(Employee emp1: empDao.getAllEmployees()) {
			
			System.out.println("Employee: {EmpId : "+emp1.getId()+", EmpName : "+emp1.geteName());
		}
		
	}
	

}