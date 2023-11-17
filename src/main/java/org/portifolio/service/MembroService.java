package org.portifolio.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.portifolio.adapter.MembroAdapter;
import org.portifolio.entity.Membro;
import org.portifolio.entity.Pessoa;
import org.portifolio.repository.MembroRepository;
import org.portifolio.repository.PessoaRepository;
import org.portifolio.vo.MembroVO;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MembroService {

	private final  MembroRepository membroRepository;

	private final PessoaRepository pessoaRepository;


	public List<MembroVO> findAll() throws Exception {
		List<Membro> listMembro = membroRepository.findAll();
		if (listMembro.isEmpty()) {
			throw new Exception("Não existe nenhum membro cadastrado!");
		}
		return MembroAdapter.modelToVo(listMembro);
	}

	public MembroVO save(MembroVO params) throws Exception {
		Optional<Pessoa> pessoa = this.pessoaRepository.findById(params.getIdPessoa());
		if (!pessoa.isPresent()) {
			throw new Exception("O Gerente informado para esse projeto não existe");
		}
		Membro entity = MembroAdapter.voToModel(params);
		this.membroRepository.save(entity);
		return params;
	}


	public MembroVO alter(MembroVO params) {
		Optional<Membro> pro =	this.membroRepository.findByIdProjeto(params.getIdProjeto());
		if (!pro.isPresent()) {
			params.setMsg("O membro informado não existe favor verificar o membro");
			return params;
		}
		Membro entity = MembroAdapter.voToModel(params);
		this.membroRepository.save(entity);

		return params;
	}

	public MembroVO excluir(MembroVO params) {
		Optional<Membro> pro =	this.membroRepository.findByIdProjeto(params.getIdProjeto());
		if (!pro.isPresent()) {
			params.setMsg("O membro informado não existe favor verificar");
			return params;
		}
		this.membroRepository.delete(pro.get());

		return params;
	}

    
    
}
