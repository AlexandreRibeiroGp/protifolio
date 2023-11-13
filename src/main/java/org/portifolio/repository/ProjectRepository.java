package org.portifolio.repository;

import java.util.Optional;

import org.portifolio.entity.Pessoa;
import org.portifolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>  , JpaSpecificationExecutor<Project> {
	
	Optional<Project> findById(Long sku);
}