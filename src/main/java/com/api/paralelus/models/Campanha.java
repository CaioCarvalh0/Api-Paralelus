package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.*;

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

}
