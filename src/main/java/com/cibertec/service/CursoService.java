package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.model.Curso;
import com.cibertec.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cursorepository;
	
	
	public Curso addCurso(Curso carrera){
		Curso saveCarreratoDB=this.cursorepository.save(carrera);
		return saveCarreratoDB;
	}
	public List<Curso> listarCursos() {
        return cursorepository.findAll();
    }
	

}
