package com.tecup.eva02Chocce.domain.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "tourment")
public class Tourment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @Column
    private int round;

    @Column
    private String type;


    public Tourment() {
    }

    public Tourment(int id, String name, int round, String type) {
        this.id = id;
        this.name = name;
        this.round = round;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tourment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", round=" + round +
                ", type='" + type + '\'' +
                '}';
    }
}
