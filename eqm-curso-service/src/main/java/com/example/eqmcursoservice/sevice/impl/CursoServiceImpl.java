package com.example.eqmcursoservice.sevice.impl;

import com.example.eqmcursoservice.entity.Curso;
import com.example.eqmcursoservice.repository.CursoRepository;

import com.example.eqmcursoservice.sevice.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerPorId(Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }

    @Override
    public Curso actualizarCurso(Integer id, Curso cursoActualizado) {
        if (cursoRepository.existsById(id)) {
            cursoActualizado.setId(id);
            return cursoRepository.save(cursoActualizado);
        }
        return null;
    }

    @Override
    public boolean eliminarCurso(Integer id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

