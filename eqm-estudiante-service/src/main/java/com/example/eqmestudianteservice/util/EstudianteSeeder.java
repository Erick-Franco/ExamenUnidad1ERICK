package com.example.eqmestudianteservice.util;

import com.example.eqmestudianteservice.entity.Estudiante;
import com.example.eqmestudianteservice.repository.EstudianteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EstudianteSeeder implements CommandLineRunner {

    private final EstudianteRepository estudianteRepository;

    public EstudianteSeeder(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public void run(String... args) {
        if (estudianteRepository.count() == 0) {
            Estudiante est1 = new Estudiante();
            est1.setNombre("Carlos Pérez");
            est1.setCarrera("Ingeniería de Sistemas");
            est1.setDocumento("DNI12345678");
            est1.setEstado("Activo");
            est1.setCicloActual(5);

            Estudiante est2 = new Estudiante();
            est2.setNombre("María López");
            est2.setCarrera("Administración");
            est2.setDocumento("DNI87654321");
            est2.setEstado("Inactivo");
            est2.setCicloActual(3);

            Estudiante est3 = new Estudiante();
            est3.setNombre("José Ramírez");
            est3.setCarrera("Contabilidad");
            est3.setDocumento("DNI45678912");
            est3.setEstado("Activo");
            est3.setCicloActual(7);

            Estudiante est4 = new Estudiante();
            est3.setNombre("José Quispe");
            est3.setCarrera("Ambiental");
            est3.setDocumento("DNI45678948");
            est3.setEstado("Activo");
            est3.setCicloActual(2);

            estudianteRepository.save(est1);
            estudianteRepository.save(est2);
            estudianteRepository.save(est3);
            estudianteRepository.save(est4);


            System.out.println("Datos de estudiantes insertados correctamente.");
        } else {
            System.out.println("Los estudiantes ya existen, no se insertaron datos.");
        }
    }
}
