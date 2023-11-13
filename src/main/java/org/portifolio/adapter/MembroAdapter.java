package org.portifolio.adapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.portifolio.entity.Membro;
import org.portifolio.vo.MembroVO;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;





public class MembroAdapter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static MembroVO modelToVo(final Membro entity) {
		Assert.notNull(entity, "Objeto não pode ser nulo!");

		MembroVO vo = new MembroVO();

		final ModelMapper mapper = new ModelMapper();

		mapper.map(entity, vo);

		return vo;
	}

	public static Membro voToModel(MembroVO vo) {
		Assert.notNull(vo, "Objeto não pode ser nulo!");

		Membro entity = new Membro();

		final ModelMapper mapper = new ModelMapper();

		mapper.map(vo, entity);

		return entity;
	}
	
	
	public static List<MembroVO> modelToVo(final List<Membro> listEntity) {
		if (CollectionUtils.isEmpty(listEntity)) {
			return new ArrayList<>();
		}

		return listEntity.stream().map(MembroAdapter::modelToVo).collect(Collectors.toList());

	}


	
	public static List<Membro> voToModel(final List<MembroVO> listVo) {
		if (CollectionUtils.isEmpty(listVo)) {
			return new ArrayList<>();
		}

		return listVo.stream().map(MembroAdapter::voToModel).collect(Collectors.toList());

	}
	
	
}
