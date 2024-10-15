package com.tecup.eva02Chocce.domain.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "career")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @Column
    private String boos;

    public Career() {
    }

    public Career(int id, String name, String boos) {
        this.id = id;
        this.name = name;
        this.boos = boos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int departId) {
        this.id = departId;
    }

    public String getBoos() {
        return boos;
    }

    public void setBoos(String boos) {
        this.boos = boos;
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", boos='" + boos + '\'' +
                '}';
    }
}
