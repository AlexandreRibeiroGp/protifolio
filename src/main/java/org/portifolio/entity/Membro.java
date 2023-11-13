package org.portifolio.entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "membros")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "membros_idprojeto_seq")
    @SequenceGenerator(name = "membros_idprojeto_seq", sequenceName = "membros_idprojeto_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "idprojeto")
    private Long idProjeto;

    @Column(name = "idpessoa")
    private Long idPessoa;
}
