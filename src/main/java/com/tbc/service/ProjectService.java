package com.tbc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.tbc.entity.Project;
import com.tbc.repo.projectRepo;

@Service
public class ProjectService {

	@Autowired
	private projectRepo projectRepo;
	
	public List<Project> getAllProject(){
		return projectRepo.findAll();
	}
	
	 public void saveProject(Project project) {
	        projectRepo.save(project); // Save project to the database
	    }
	 
	 public void deleteProject(Long id) {
		  projectRepo.deleteById(id);
	 }
	 public Optional<Project> getproject(Long id) {
		return projectRepo.findById(id);
	 }
	 
	 public Project getProjectById(Long id) {
	        return projectRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + id));
	    }
	
	
	
}
