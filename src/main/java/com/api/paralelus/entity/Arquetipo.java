package com.api.paralelus.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "arquetipo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Arquetipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "caminho_id", nullable = false)
    private Caminho caminho;
}
