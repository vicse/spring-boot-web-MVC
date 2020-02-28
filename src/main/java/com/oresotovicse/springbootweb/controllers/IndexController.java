package com.oresotovicse.springbootweb.controllers;

import com.oresotovicse.springbootweb.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;



    @GetMapping({"/index", "/home", "/"})
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";

    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Vicse");
        usuario.setApellido("Ore Soto");
        usuario.setEmail("vicseore@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()) );
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {

        model.addAttribute("titulo", textoListar);

        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Andres", "Gúzman", "andre@gmail.com"));
        usuarios.add(new Usuario("Vicse", "Ore", "vicseore@gmail.com"));
        usuarios.add(new Usuario("Maria Isabel", "Estrada", "marisabel@gmail.com"));

        return usuarios;

    }

}
