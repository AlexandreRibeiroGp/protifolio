package org.portifolio.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PessoaVO {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;


	@JsonProperty("dataNascimento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("funcionario")
	private Boolean funcionario;

	@JsonProperty("msg")
	private String msg;

		

}
