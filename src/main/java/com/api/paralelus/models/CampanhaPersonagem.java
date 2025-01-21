package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "campanha_personagem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampanhaPersonagem {

    @Id
    @ManyToOne
    @JoinColumn(name = "campanha_id", nullable = false)
    private Campanha campanha;

    @Id
    @ManyToOne
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}