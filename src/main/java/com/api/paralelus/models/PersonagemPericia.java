package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personagem_pericia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonagemPericia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    @ManyToOne
    @JoinColumn(name = "pericia_id", nullable = false)
    private Pericia pericia;

    private Integer pontos;
}
