package org.portifolio.adapter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.portifolio.entity.Pessoa;
import org.portifolio.vo.PessoaVO;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;




public class PessoaAdapter implements Serializable {

    private static final long serialVersionUID = 1L;

    public static PessoaVO modelToVo(final Pessoa entity) {
        Assert.notNull(entity, "Objeto não pode ser nulo!");

        PessoaVO vo = new PessoaVO();

        final ModelMapper mapper = new ModelMapper();

        mapper.map(entity, vo);

        return vo;
    }

    public static Pessoa voToModel(PessoaVO vo) {
        Assert.notNull(vo, "Objeto não pode ser nulo!");

        Pessoa entity = new Pessoa();

        final ModelMapper mapper = new ModelMapper();

        mapper.map(vo, entity);

        return entity;
    }


    public static List<PessoaVO> modelToVo(final List<Pessoa> listEntity) {
        if (CollectionUtils.isEmpty(listEntity)) {
            return new ArrayList<>();
        }

        return listEntity.stream().map(PessoaAdapter::modelToVo).collect(Collectors.toList());

    }



    public static List<Pessoa> voToModel(final List<PessoaVO> listVo) {
        if (CollectionUtils.isEmpty(listVo)) {
            return new ArrayList<>();
        }

        return listVo.stream().map(PessoaAdapter::voToModel).collect(Collectors.toList());

    }


}
