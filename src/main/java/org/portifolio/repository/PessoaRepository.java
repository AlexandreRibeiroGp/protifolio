package org.portifolio.repository;


import org.portifolio.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> , JpaSpecificationExecutor<Pessoa> {
	
	Pessoa findByNome(String name);
	
}