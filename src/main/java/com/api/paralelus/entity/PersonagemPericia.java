package com.api.paralelus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties("personagem")
public class PersonagemPericia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    @JsonIgnore
    private Personagem personagem;

    @ManyToOne
    @JoinColumn(name = "pericia_id", nullable = false)
    private Pericia pericia;

    @Column(name = "pontos")
    private Integer pontos;
}
