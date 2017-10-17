package com.example.HouseRules.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String category;

    @Column
    private String objective;

    @Column(length = 5000)
    private String rules;

    @Column
    private String number_of_players;

    @Column
    private String player_age_range;

    @Column
    private byte[] image;

    private List<Alternate> alternates = new ArrayList<>();


    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getNumber_of_players() {
        return number_of_players;
    }

    public void setNumber_of_players(String number_of_players) {
        this.number_of_players = number_of_players;
    }

    public String getPlayer_age_range() {
        return player_age_range;
    }

    public void setPlayer_age_range(String player_age_range) {
        this.player_age_range = player_age_range;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @OneToMany(mappedBy = "game")
    public List<Alternate> getAlternates() {
        return alternates;
    }

    public void setAlternates(List<Alternate> alternates) {
        this.alternates = alternates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return getId() == game.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", objective='" + objective + '\'' +
                ", rules='" + rules + '\'' +
                ", number_of_players='" + number_of_players + '\'' +
                ", player_age_range='" + player_age_range + '\'' +
                ", image=" + Arrays.toString(image) +
                ", alternates=" + alternates +
                '}';
    }
}
