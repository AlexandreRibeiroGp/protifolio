package org.portifolio.adapter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.portifolio.entity.Project;
import org.portifolio.vo.ProjectVO;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;




public class ProjectAdapter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static ProjectVO modelToVo(final Project entity) {
		Assert.notNull(entity, "Objeto não pode ser nulo!");

		ProjectVO vo = new ProjectVO();

		final ModelMapper mapper = new ModelMapper();

		mapper.map(entity, vo);

		return vo;
	}

	public static Project voToModel(ProjectVO vo) {
		Assert.notNull(vo, "Objeto não pode ser nulo!");

		Project entity = new Project();

		final ModelMapper mapper = new ModelMapper();

		mapper.map(vo, entity);
		entity.setDataPrevFim(vo.getDataPrevFim());
        return entity;
	}
	
	
	public static List<ProjectVO> modelToVo(final List<Project> listEntity) {
		if (CollectionUtils.isEmpty(listEntity)) {
			return new ArrayList<>();
		}

		return listEntity.stream().map(ProjectAdapter::modelToVo).collect(Collectors.toList());

	}


	
	public static List<Project> voToModel(final List<ProjectVO> listVo) {
		if (CollectionUtils.isEmpty(listVo)) {
			return new ArrayList<>();
		}

		return listVo.stream().map(ProjectAdapter::voToModel).collect(Collectors.toList());

	}
	
	
}
