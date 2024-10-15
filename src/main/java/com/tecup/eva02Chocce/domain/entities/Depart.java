package com.tecup.eva02Chocce.domain.entities;
import jakarta.persistence.*;


@Entity
@Table(name = "depart")

public class Depart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column
    private String name;
    @Column
    private int cycle;
    @Column
    private String section;


    public Depart() {

    }

    public Depart(int id, String name, int cycle, String section) {
        this.id = id;
        this.name = name;
        this.cycle = cycle;
        this.section = section;
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

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cycle=" + cycle +
                ", section='" + section + '\'' +
                '}';
    }
}
