package org.portifolio.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "PROJETO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto_id_seq")
    @SequenceGenerator(name = "projeto_id_seq", sequenceName = "projeto_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_previsao_fim")
    private LocalDate dataPrevFim;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private String status;


    @Column(name = "orcamento")
    private BigDecimal orcamento;

    @Column(name = "risco")
    private String risco;

    @OneToOne
    @JoinColumn(name = "idgerente")
    private Pessoa idGerente;

}
