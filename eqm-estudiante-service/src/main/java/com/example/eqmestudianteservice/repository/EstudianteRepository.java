package com.example.eqmestudianteservice.repository;

import com.example.eqmestudianteservice.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    boolean existsByDocumento(String documento);

}
