package com.api.paralelus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "campanha")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "mestre", nullable = false)
    private Usuario mestre;

    private Integer nivel;

    private Boolean ativa;

    private String introducao;

    @Column(name = "capa")
    private String capa;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "campanha_personagem",
            joinColumns = @JoinColumn(name = "campanha_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> jogadoresCampanha;

}
