package com.controledealunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledealunos.entities.Aluno;
	
	public interface AlunoRepository extends JpaRepository <Aluno, Long> {

}
