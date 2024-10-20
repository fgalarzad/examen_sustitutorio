package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.model.Curso;
import com.cibertec.model.Estudiante;
import com.cibertec.service.CursoService;
import com.cibertec.service.EstudianteService;

import java.util.List;

@Controller
public class CViewController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EstudianteService estudianteService;

    
    @GetMapping("/cursos/nueva")
    public String mostrarFormularioRegistro(Model model) {
        Curso curso = new Curso();
        List<Estudiante> estudiantes = estudianteService.listarEstudiantes();
        model.addAttribute("curso", curso);
        model.addAttribute("estudiantes", estudiantes); // Lista de estudiantes para seleccionar
        return "registro-curso";
    }

  
    @PostMapping("/cursos/registrar")
    public String registrarCurso(@ModelAttribute("curso") Curso curso) {
    	Estudiante estudiante = estudianteService.obtenerEstudiantePorId(curso.getEstudiante().getIdEstudiante());
        curso.setEstudiante(estudiante);
        cursoService.addCurso(curso);
        return "redirect:/cursos/lista";
    }

   
    @GetMapping("/cursos/lista")
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.listarCursos();
        model.addAttribute("cursos", cursos);
        return "lista-cursos";
    }
}

