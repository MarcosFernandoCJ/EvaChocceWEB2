package com.tecup.eva02Chocce.controllers;
import com.tecup.eva02Chocce.domain.entities.Score;
import com.tecup.eva02Chocce.service.score.ScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @RequestMapping(value = "/scores/listar", method = RequestMethod.GET)
    public String listarPuntajes(Model model) {
        model.addAttribute("scores", scoreService.listar());
        System.out.println(scoreService.listar());
        return "/score/listar";
    }

    @RequestMapping(value = "/score/form")
    public String crear(Map<String, Object> model) {

        Score score = new Score();
        model.put("score", score);
        return "/score/form";
    }

    @RequestMapping(value = "/score/form", method = RequestMethod.POST)
    public String guardar(@Valid Score score, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "/score/form";
        }

        scoreService.grabar(score);
        status.setComplete();
        return "redirect:/scores/listar";
    }

    //Form para editar
    @RequestMapping(value="/score/form/{id}")
    public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {

        Score score = null;

        if(id > 0) {
            score = scoreService.buscar(id);
        } else {
            return "redirect:/scores/listar";
        }
        model.put("score", score);
        return "/score/form";
    }

    //Eliminar
    @RequestMapping(value="score/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Integer id) {

        if(id > 0) {
            scoreService.eliminar(id);
        }
        return "redirect:/scores/listar";
    }

    //Ver
    @RequestMapping(value="/score/ver")
    public String ver(Model model) {
        model.addAttribute("scores", scoreService.listar());
        model.addAttribute("titulo", "Lista de puntos");

        return "/score/ver";
    }
}
