package org.portifolio.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;


@Data
public class MembroVO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("idProjeto")
	private Long idProjeto;

	@JsonProperty("idPessoa")
	private Long idPessoa;

	@JsonProperty("msg")
	private String msg;


}
