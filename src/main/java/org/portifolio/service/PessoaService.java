package org.portifolio.service;

import java.util.List;
import java.util.Optional;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.portifolio.adapter.PessoaAdapter;
import org.portifolio.entity.Pessoa;
import org.portifolio.repository.PessoaRepository;
import org.portifolio.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaService  {

	private final PessoaRepository pessoaRepository;

	public List<PessoaVO> findAll() throws Exception {
		List<Pessoa> listPessoa = pessoaRepository.findAll();
		if (listPessoa.isEmpty()) {
			throw new Exception("Não existe nenhuma pessoa cadastrada!");
		}
		return PessoaAdapter.modelToVo(listPessoa);
	}

	public PessoaVO save(PessoaVO params) throws Exception {
		Pessoa entity = PessoaAdapter.voToModel(params);
		this.pessoaRepository.save(entity);
		return params;
	}


	public PessoaVO alter(PessoaVO params) {
		Optional<Pessoa> pro =	this.pessoaRepository.findById(params.getId());
		if (!pro.isPresent()) {
			params.setMsg("O projeto informado não existe favor verificar o sku");
			return params;
		}


		Pessoa entity = PessoaAdapter.voToModel(params);
		this.pessoaRepository.save(entity);

		return params;
	}

	public PessoaVO excluir(PessoaVO params) {
		Optional<Pessoa> pro =	this.pessoaRepository.findById(params.getId());
		if (!pro.isPresent()) {
			params.setMsg("A pessoa informada não existe favor verificar");
			return params;
		}
		this.pessoaRepository.delete(pro.get());

		return params;
	}
    
}
