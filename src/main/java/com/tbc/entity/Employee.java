package com.tbc.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	private String empName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_task", joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "empId"),
	          inverseJoinColumns = @JoinColumn(name="task_Id",referencedColumnName = "taskId"))
    private List<Task> task= new ArrayList<>();

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Employee(Long empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
