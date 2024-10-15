package com.tecup.eva02Chocce.domain.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "score")

public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String career;

    @Column
    private int score;

    @Column
    private int top;


    public Score() {
    }

    public Score(int id, String career, int score, int top) {
        this.id = id;
        this.career = career;
        this.score = score;
        this.top = top;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", career='" + career + '\'' +
                ", score=" + score +
                ", top=" + top +
                '}';
    }
}
