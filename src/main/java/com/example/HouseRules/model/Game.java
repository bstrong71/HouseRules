package com.example.HouseRules.model;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "number_of_players")
    private String numberOfPlayers;

    @Column(name = "player_age_range")
    private String playerAgeRange;

    @Column
    private byte[] image;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "game")
    private List<Alternate> alternates = new ArrayList<>();


    public Game() {
        this.dateCreated = LocalDate.now();
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

    public String getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(String numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getPlayerAgeRange() {
        return playerAgeRange;
    }

    public void setPlayerAgeRange(String playerAgeRange) {
        this.playerAgeRange = playerAgeRange;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

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
                ", numberOfPlayers='" + numberOfPlayers + '\'' +
                ", playerAgeRange='" + playerAgeRange + '\'' +
                ", image=" + Arrays.toString(image) +
                ", dateCreated=" + dateCreated +
                ", alternates=" + alternates +
                '}';
    }
}
