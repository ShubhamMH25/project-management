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
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	//  meaning that one project can have multiple employees associated with it.
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name="project_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="employee_Id",referencedColumnName = "empId"))
	private List<Employee>employees=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_task", joinColumns = @JoinColumn(name="project_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="task_Id",referencedColumnName = "taskId"))
	private List<Task> task=new ArrayList<>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
