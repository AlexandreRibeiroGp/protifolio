package org.portifolio.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProjectVO {


	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("dataInicio")
	private LocalDate dataInicio;


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonProperty("dataPrevFim")
	private LocalDate dataPrevFim;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("dataFim")
	private LocalDate dataFim;

	@JsonProperty("descricao")
	private String descricao;

	@JsonProperty("status")
	private String status;

	@JsonProperty("orcamento")
	private BigDecimal orcamento;

	@JsonProperty("risco")
	private String risco;

	@JsonProperty("msg")
	private String msg;

	@JsonProperty("idGerente")
	private Long idGerente;


}
