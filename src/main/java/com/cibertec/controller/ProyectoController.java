package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.Estudiante;
import com.cibertec.service.EstudianteService;


@RestController
@RequestMapping("/api/Estudiante")
public class ProyectoController {
    
    @Autowired
    private EstudianteService estudianteservice;
    
    @PostMapping("/registro")
    public ResponseEntity<Estudiante> saveEstudiante(@RequestBody Estudiante estudiante) throws Exception {
        Estudiante saveEstudiantetoDB = this.estudianteservice.addEstudiante(estudiante);
        return new ResponseEntity<>(saveEstudiantetoDB, HttpStatus.CREATED); // Devuelve JSON
    }
}
