package com.api.paralelus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "atributos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atributos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer forca;
    private Integer agilidade;
    private Integer intelecto;
    private Integer poder;
    private Integer sanidade;
    private Integer resistencia;

}
