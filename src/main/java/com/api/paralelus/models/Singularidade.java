package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "singularidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Singularidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer criacao;
    private Integer manipulacao;
    private Integer ampliacao;
    private Integer difusao;
    private Integer corporeo;
    private Integer espacial;
    private String descricao;

}
