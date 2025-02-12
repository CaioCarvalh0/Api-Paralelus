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

    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    @Column(name = "inventario")
    private String inventario;

    @Column(name = "vida")
    private Integer vida;

    @Column(name = "energia")
    private Integer energia;

    @Column(name = "defesa")
    private Integer defesa;

    @Column(name = "vidamax")
    private Integer vidaMax;

    @Column(name = "energiamax")
    private Integer energiaMax;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonagemPericia> personagemPericias = new ArrayList<>();

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonagemArquetipo> personagemArquetipos = new ArrayList<>();

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonagemCaminho> personagemCaminhos = new ArrayList<>();

}
