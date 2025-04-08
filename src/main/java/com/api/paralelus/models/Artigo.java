package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "artigo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "secao_id")
    private Secao secao;

    private String titulo;

    private String conteudo;

    private Integer ordem;
}
