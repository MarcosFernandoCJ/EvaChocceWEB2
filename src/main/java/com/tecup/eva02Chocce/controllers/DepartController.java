package com.tecup.eva02Chocce.controllers;


import com.tecup.eva02Chocce.domain.entities.Depart;
import com.tecup.eva02Chocce.service.depart.DepartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("depart")
public class DepartController {
    @Autowired
    DepartService departService;

    @RequestMapping(value = "/departs/listar", method = RequestMethod.GET)
    public String listarDepartamentos(Model model) {
        model.addAttribute("departs", departService.listar());
        System.out.println(departService.listar());
        return "/depart/listar";
    }

    @RequestMapping(value = "/depart/form")
    public String crear(Map<String, Object> model) {

        Depart depart = new Depart();
        model.put("depart", depart);
        return "/depart/form";
    }

    @RequestMapping(value = "/depart/form", method = RequestMethod.POST)
    public String guardar(@Valid Depart depart, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "/depart/form";
        }

        departService.grabar(depart);
        status.setComplete();
        return "redirect:/departs/listar";
    }

    //Form para editar
    @RequestMapping(value="/depart/form/{id}")
    public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {

        Depart depart = null;

        if(id > 0) {
            depart = departService.buscar(id);
        } else {
            return "redirect:/departs/listar";
        }
        model.put("depart", depart);
        return "/depart/form";
    }

    //Eliminar
    @RequestMapping(value="depart/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Integer id) {

        if(id > 0) {
            departService.eliminar(id);
        }
        return "redirect:/departs/listar";
    }

    //Ver
    @RequestMapping(value="/depart/ver")
    public String ver(Model model) {
        model.addAttribute("departs", departService.listar());
        model.addAttribute("titulo", "Lista de departamentos");

        return "/depart/ver";
    }
}
