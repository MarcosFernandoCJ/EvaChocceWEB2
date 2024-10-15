package com.tecup.eva02Chocce.service.score;

import com.tecup.eva02Chocce.domain.entities.Score;

import java.util.List;

public interface ScoreService {
    public void grabar(Score score);
    public void eliminar(int id);
    public Score buscar(Integer id);
    public List<Score> listar();
}
