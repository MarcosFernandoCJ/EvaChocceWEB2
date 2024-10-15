package com.tecup.eva02Chocce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/career")
    public String career() {
        return "career/listar";
    }

    @GetMapping("/depart")
    public String depart() {return "depart/listar";}

    @GetMapping("/event")
    public String event() {return "event/listar";}

    @GetMapping("/score")
    public String score() {return "score/listar";}

    @GetMapping("/tourment")
    public String tourment() {return "tourment/listar";}

    @GetMapping("/usuario")
    public String user() {return "usuario/listar";}

}
