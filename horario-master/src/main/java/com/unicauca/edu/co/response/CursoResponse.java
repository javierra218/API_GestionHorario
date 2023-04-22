package com.unicauca.edu.co.response;

import java.util.List;

import com.unicauca.edu.co.model.Curso;


public class CursoResponse {

    private List<Curso> curso;
    
    private List<Curso> cursoAsig;

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }
    
    public List<Curso> getCursoAsig() {
        return cursoAsig;
    }

    public void setCursoAsig(List<Curso> cursoAsig) {
        this.cursoAsig = cursoAsig;
    }
}