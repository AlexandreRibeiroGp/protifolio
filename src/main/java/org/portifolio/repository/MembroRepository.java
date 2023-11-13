package org.portifolio.repository;


import org.portifolio.entity.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembroRepository extends JpaRepository<Membro,Long>, JpaSpecificationExecutor<Membro> {

    Optional<Membro> findByIdProjeto(Long idProjeto);
	
}