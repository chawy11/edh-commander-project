package com.chawy.edh_commander_test.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "comandantes_mono")
public class MonoCommander {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color")
    private String color;

    @Column(name = "comandante")
    private String comandante;

    @Column(name = "popularidad")
    private int popularidad;

    @Column(name = "estrategias")
    @Convert(converter = StringListConverter.class)
    private List<String> estrategias;

    @Transient
    private double score;

    public MonoCommander() {
    }

    public MonoCommander(Long id, String comandante, String color, int popularidad, List<String> estrategias) {
        this.id = id;
        this.comandante = comandante;
        this.color = color;
        this.popularidad = popularidad;
        this.estrategias = estrategias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getEstrategias() {
        return estrategias;
    }

    public void setEstrategias(List<String> estrategias) {
        this.estrategias = estrategias;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComandante() {
        return comandante;
    }

    public void setComandante(String comandante) {
        this.comandante = comandante;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
