package org.portifolio.service;

import java.util.List;
import java.util.Optional;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.portifolio.adapter.ProjectAdapter;
import org.portifolio.entity.Membro;
import org.portifolio.entity.Pessoa;
import org.portifolio.entity.Project;
import org.portifolio.repository.MembroRepository;
import org.portifolio.repository.PessoaRepository;
import org.portifolio.repository.ProjectRepository;
import org.portifolio.vo.ProjectVO;
import org.springframework.stereotype.Service;


@Service
@Log4j2
@RequiredArgsConstructor
public class ProjectService  {

    private final ProjectRepository projetoRepository;

	private final MembroRepository membroRepository;

	private final PessoaRepository pessoaRepository;



	public List<ProjectVO> findAll() throws Exception {
		List<Project> listProject = projetoRepository.findAll();
		if (listProject.isEmpty()) {
			throw new Exception("Não existe nenhum projeto cadastrado!");
		}
		return ProjectAdapter.modelToVo(listProject);
	}

    public ProjectVO save(ProjectVO params) throws Exception {
		Optional<Pessoa> pessoa = this.pessoaRepository.findById(params.getIdGerente());




		if (!pessoa.isPresent()) throw new Exception("O Gerente informado para esse projeto não existe");
		if (params.getStatus() == null) {
			throw new Exception("favor informar o status do projeto");
		}
		if (params.getRisco() == null) {
			throw new Exception("favor informar qual o risco do projeto");
		}


		Project entity = ProjectAdapter.voToModel(params);
		this.projetoRepository.save(entity);
		return params;
	}
    

    public ProjectVO alter(ProjectVO params) throws Exception {
		Optional<Pessoa> pessoaFun = this.pessoaRepository.findById(params.getIdGerente());
    	Optional<Project> pro =	this.projetoRepository.findById(params.getId());
		if (!pro.isPresent()) {
			params.setMsg("O projeto informado não existe favor verificar o sku");
			return params;
		}
		if (!pessoaFun.isPresent()  ) {
			throw new Exception("O membro que deseja adicionar não existe");
		}
		if ( !pessoaFun.get().getFuncionario()) {
			throw new Exception("O membro que deseja adicionar não é um funcionario");
		}
		Optional<Pessoa> pessoa =	this.pessoaRepository.findById(params.getIdGerente());
		if (!pessoa.isPresent()) {
			params.setMsg("O Gerente informado para esse projeto não existe");
			return params;
		}
		Project entity = ProjectAdapter.voToModel(params);
		this.projetoRepository.save(entity);
	
		return params;
	}

	public ProjectVO excluir(ProjectVO params) {
		Optional<Project> pro =	this.projetoRepository.findById(params.getId());
		if (!pro.isPresent()) {
			params.setMsg("O projeto informado não existe favor verificar o sku");
			return params;
		}
		if (pro.get().getStatus().equals("andamento") ||pro.get().getStatus().equals("encerrado")) {
			params.setMsg("O projeto em questão está em andamento ou encerrado por tanto não pode ser exclcuido");
			return params;
		}
		this.projetoRepository.delete(pro.get());

		return params;
	}
    
}
