package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pericia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pericia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "pericia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonagemPericia> personagemPericias = new ArrayList<>();

}
