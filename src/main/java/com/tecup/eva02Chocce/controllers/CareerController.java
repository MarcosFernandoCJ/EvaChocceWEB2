package com.tecup.eva02Chocce.controllers;

import com.tecup.eva02Chocce.domain.entities.Career;
import com.tecup.eva02Chocce.service.career.CareerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("career")
public class CareerController {
@Autowired
    CareerService careerService;

    @RequestMapping(value = "/careers/listar", method = RequestMethod.GET)
    public String listarCarreras(Model model) {
        model.addAttribute("careers", careerService.listar());
        System.out.println(careerService.listar());
        return "/career/listar";
    }

    @RequestMapping(value = "/career/form")
    public String crear(Map<String, Object> model) {

        Career career = new Career();
        model.put("career", career);
        return "/career/form";
    }

    @RequestMapping(value = "/career/form", method = RequestMethod.POST)
    public String guardar(@Valid Career career, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "/career/form";
        }

        careerService.grabar(career);
        status.setComplete();
        return "redirect:/careers/listar";
    }

    //Form para editar
    @RequestMapping(value="/career/form/{id}")
    public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {

        Career career = null;

        if(id > 0) {
            career = careerService.buscar(id);
        } else {
            return "redirect:/careers/listar";
        }
        model.put("career", career);
        return "/career/form";
    }

    //Eliminar
    @RequestMapping(value="career/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Integer id) {

        if(id > 0) {
            careerService.eliminar(id);
        }
        return "redirect:/careers/listar";
    }

    //Ver
    @RequestMapping(value="/career/ver")
    public String ver(Model model) {
        model.addAttribute("careers", careerService.listar());
        model.addAttribute("titulo", "Lista de career");

        return "/career/ver";
    }
}
