package com.educacaoonlineapi.repository;

import com.educacaoonlineapi.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
