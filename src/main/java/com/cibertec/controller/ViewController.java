package com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.cibertec.model.Estudiante;

import com.cibertec.service.EstudianteService;
@Controller
public class ViewController {
	
	@Autowired
    private EstudianteService estudianteService;

    // Muestra el formulario de registro de estudiante
    @GetMapping("/estudiantes/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "registro-estudiante";
    }

    // Maneja el envío del formulario de registro
    @PostMapping("/estudiantes/registrar")
    public String registrarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) throws Exception {
        estudianteService.addEstudiante(estudiante);
        return "redirect:/estudiantes/lista";
    }

    // Muestra la lista de estudiantes
    @GetMapping("/estudiantes/lista")
    public String listarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "lista-estudiantes";
    }
}
