package com.tbc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tbc.entity.Project;

public interface projectRepo extends JpaRepository<Project, Long>{

}
