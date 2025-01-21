package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personagem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "atributos_id", nullable = false)
    private Atributos atributos;

    private String nome;

    private String caracteristica;

    //TODO: Criar a entidade raça
    private String raca;

    private String singularidade;

    private String historia;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonagemPericia> personagemPericias = new ArrayList<>();

}
