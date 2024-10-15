package com.tecup.eva02Chocce.controllers;


import com.tecup.eva02Chocce.domain.entities.Usuario;
import com.tecup.eva02Chocce.service.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuarios/listar", method = RequestMethod.GET)
    public String listarUsuario(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        System.out.println(usuarioService.listar());
        return "/usuario/listar";
    }

    @RequestMapping(value = "/usuario/form")
    public String crear(Map<String, Object> model) {

        Usuario usuario = new Usuario();
        model.put("usuario", usuario);
        return "/usuario/form";
    }

    @RequestMapping(value = "/usuario/form", method = RequestMethod.POST)
    public String guardar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "/usuario/form";
        }

        usuarioService.grabar(usuario);
        status.setComplete();
        return "redirect:/usuarios/listar";
    }

    //Form para editar
    @RequestMapping(value="/usuario/form/{id}")
    public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {

        Usuario usuario = null;

        if(id > 0) {
            usuario = usuarioService.buscar(id);
        } else {
            return "redirect:/usuarios/listar";
        }
        model.put("usuario", usuario);
        return "/usuario/form";
    }

    //Eliminar
    @RequestMapping(value="usuario/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Integer id) {

        if(id > 0) {
            usuarioService.eliminar(id);
        }
        return "redirect:/usuarios/listar";
    }

    //Ver
    @RequestMapping(value="/usuario/ver")
    public String ver(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("titulo", "Lista de usuarios");

        return "/usuario/ver";
    }
}
