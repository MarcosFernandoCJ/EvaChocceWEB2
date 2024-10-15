package com.tecup.eva02Chocce.controllers;

import com.tecup.eva02Chocce.domain.entities.Tourment;
import com.tecup.eva02Chocce.service.tourment.TourmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("tourment")
public class TourmentController {
    @Autowired
    TourmentService tourmentService;

    @RequestMapping(value = "/tourments/listar", method = RequestMethod.GET)
    public String listarTourment(Model model) {
        model.addAttribute("tourments", tourmentService.listar());
        System.out.println(tourmentService.listar());
        return "/tourment/listar";
    }

    @RequestMapping(value = "/tourment/form")
    public String crear(Map<String, Object> model) {

        Tourment tourment = new Tourment();
        model.put("tourment", tourment);
        return "/tourment/form";
    }

    @RequestMapping(value = "/tourment/form", method = RequestMethod.POST)
    public String guardar(@Valid Tourment score, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "/tourment/form";
        }

        tourmentService.grabar(score);
        status.setComplete();
        return "redirect:/tourments/listar";
    }

    //Form para editar
    @RequestMapping(value="/tourment/form/{id}")
    public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {

        Tourment tourment = null;

        if(id > 0) {
            tourment = tourmentService.buscar(id);
        } else {
            return "redirect:/tourments/listar";
        }
        model.put("tourment", tourment);
        return "/tourment/form";
    }

    //Eliminar
    @RequestMapping(value="tourment/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Integer id) {

        if(id > 0) {
            tourmentService.eliminar(id);
        }
        return "redirect:/tourments/listar";
    }

    //Ver
    @RequestMapping(value="/tourment/ver")
    public String ver(Model model) {
        model.addAttribute("tourments", tourmentService.listar());
        model.addAttribute("titulo", "Lista de tourments");

        return "/tourment/ver";
    }
}
