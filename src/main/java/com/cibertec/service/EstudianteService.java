package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cibertec.model.Estudiante;
import com.cibertec.repository.EstudianteRepository;

@Service
public class EstudianteService {
	@Autowired
	private EstudianteRepository estudianterepository;
	
	@Transactional
	public Estudiante addEstudiante(Estudiante estudiante)throws Exception{
		Estudiante saveEstudiantetoDB=this.estudianterepository.save(estudiante);
		return saveEstudiantetoDB;
	}
	public List<Estudiante> listarEstudiantes() {
        return estudianterepository.findAll();
    }
	public Estudiante obtenerEstudiantePorId(int id) {
	    return estudianterepository.findById(id).orElse(null);
	}
}
