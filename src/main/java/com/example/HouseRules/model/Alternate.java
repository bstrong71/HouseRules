package com.example.HouseRules.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "alternates")
public class Alternate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "game_id")
    private Game game;

    private String title;
    private String objective;
    
}
