package com.tbc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbc.entity.Project;
import com.tbc.service.ProjectService;


@Controller
public class ProjectController {
	
    @Autowired
	private ProjectService projectService;

    @GetMapping("/")
    public String home() {
        return "home";
    }
    
    @GetMapping("/getAllProjects")
    public String getAllProjects(Model model) {
        List<Project> projects = projectService.getAllProject();        
        model.addAttribute("project", projects);
        model.addAttribute("newProject", new Project());
        return "projects";
    }
    
    @PostMapping("/addProject")
    public String addProject(@ModelAttribute Project newProject) {
        projectService.saveProject(newProject);
        return "redirect:/getAllProjects"; // Redirect to update the project list
    }
    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable("id") Long id) {
    	
    	projectService.deleteProject(id);
    	return "redirect:/getAllProjects";
    }
    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable("id") Long id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("editProject", project);
        return "editProj"; // Return the same view with the project preloaded for editing
    }

    @PostMapping("/editProject")
    public String saveEditedProject(@ModelAttribute Project project) {
        projectService.saveProject(project); // Save updated project
        return "redirect:/getAllProjects";
    }

}   


	

