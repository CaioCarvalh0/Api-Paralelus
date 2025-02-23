package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "atributo_id", nullable = false)
    private Atributos atributos;

    @Column(name = "nome")
    private String nome;

    @Column(name = "caracteristica")
    private String caracteristica;

    @Column(name = "level")
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "raca_id", nullable = false)
    private Raca raca;

    @Column(name = "singularidade")
    private String singularidade;

    @Column(name = "imagem", columnDefinition = "BYTEA")
    private byte[] imagem;

    @Column(name = "inventario")
    private String inventario;

    @Column(name = "vida")
    private Integer vidaAtual;

    @Column(name = "vidamax")
    private Integer vidaMax;

    @Column(name = "energia")
    private Integer energiaAtual;

    @Column(name = "energiamax")
    private Integer energiaMax;

    @Column(name = "defesa")
    private Integer defesa;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<PersonagemPericia> personagemPericias;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Arquetipo.class)
    @JoinTable(
            name = "personagem_arquetipo",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "arquetipo_id")
    )
    private Set<Arquetipo> personagemArquetipos;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Caminho.class)
    @JoinTable(
            name = "personagem_caminho",
            joinColumns = @JoinColumn(name = "personagem_id"),
            inverseJoinColumns = @JoinColumn(name = "caminho_id")
    )
    private Set<Caminho> personagemCaminhos;

}
