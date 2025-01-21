package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "arquetipo")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Arquetipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "caminho_id", nullable = false)
    private Caminho caminho;
}
