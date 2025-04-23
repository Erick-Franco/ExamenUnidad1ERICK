package com.example.eqmmatriculaservice.repository;

import com.example.eqmmatriculaservice.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
