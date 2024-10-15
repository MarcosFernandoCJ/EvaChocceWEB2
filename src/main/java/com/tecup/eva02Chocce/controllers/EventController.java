package com.tecup.eva02Chocce.controllers;
import com.tecup.eva02Chocce.domain.entities.Event;
import com.tecup.eva02Chocce.service.event.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("event")

public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping(value = "/events/listar", method = RequestMethod.GET)
    public String listarEventos(Model model) {
        model.addAttribute("events", eventService.listar());
        System.out.println(eventService.listar());
        return "/event/listar";
    }

    @RequestMapping(value = "/event/form")
    public String crear(Map<String, Object> model) {

        Event event = new Event();
        model.put("event", event);
        return "/event/form";
    }

    @RequestMapping(value = "/event/form", method = RequestMethod.POST)
    public String guardar(@Valid Event depart, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "/event/form";
        }

        eventService.grabar(depart);
        status.setComplete();
        return "redirect:/events/listar";
    }

    //Form para editar
    @RequestMapping(value="/event/form/{id}")
    public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {

        Event event = null;

        if(id > 0) {
            event = eventService.buscar(id);
        } else {
            return "redirect:/events/listar";
        }
        model.put("event", event);
        return "/event/form";
    }

    //Eliminar
    @RequestMapping(value="event/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Integer id) {

        if(id > 0) {
            eventService.eliminar(id);
        }
        return "redirect:/events/listar";
    }

    //Ver
    @RequestMapping(value="/event/ver")
    public String ver(Model model) {
        model.addAttribute("events", eventService.listar());
        model.addAttribute("titulo", "Lista de eventos");

        return "/event/ver";
    }

}
