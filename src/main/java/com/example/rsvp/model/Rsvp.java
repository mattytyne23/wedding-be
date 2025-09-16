package com.example.rsvp.model;

import jakarta.persistence.*;

@Entity
public class Rsvp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String song;
    private String response; // "yes" or "no"
    private String drinksChoice;
    private String starter;
    private String main;
    private String dessert;
    private String allergies;

    public Rsvp() {}

    public Rsvp(String name, String song, String response, String drinksChoice, String starter, String main, String dessert, String allergies) {
        this.name = name;
        this.song = song;
        this.response = response;
        this.drinksChoice = drinksChoice;
        this.starter = starter;
        this.main = main;
        this.dessert = dessert;
        this.allergies = allergies;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSong() { return song; }
    public String getResponse() { return response; }
    public String getDrinksChoice() { return drinksChoice; }
    public String getStarter() { return starter; }
    public String getMain() { return main;}
    public String getDessert() { return  dessert; }
    public String getAllergies() { return  allergies; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSong(String  song) { this.song = song; }
    public void setResponse(String response) { this.response = response; }
    public void setDrinksChoice(String drinksChoice) { this.drinksChoice = drinksChoice; }
    public void setStarter(String starter) { this.starter = starter; }
    public void setMain(String main) { this.main = main;}
    public void setDessert(String dessert) { this.dessert = dessert;}
    public void setAllergies(String allergies ) { this.allergies = allergies;}
}