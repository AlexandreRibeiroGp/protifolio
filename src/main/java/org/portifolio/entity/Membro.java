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
    @Column(name = "idprojeto")
    private Long idProjeto;

    @Column(name = "idpessoa")
    private Long idPessoa;
}
