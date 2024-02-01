package com.controledealunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledealunos.entities.Aluno;
import com.controledealunos.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno getAlunoById(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
			return aluno.orElse(null);
	}

	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
	}
	
	public boolean deleteAluno(Long id) {
		Optional<Aluno> existealuno = alunoRepository.findById(id);
		if(existealuno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
		}
		return false;
	}
	
	public Aluno updateAluno(Long id, Aluno updateAluno) {
	    Optional<Aluno> existealuno = alunoRepository.findById(id);
	    if (existealuno.isPresent()) {
            updateAluno.setId(id);
            return alunoRepository.save(updateAluno);
	    } 
	    
	    return null;
	}	
	
}
