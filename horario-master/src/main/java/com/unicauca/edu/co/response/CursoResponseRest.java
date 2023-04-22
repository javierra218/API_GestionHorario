package com.unicauca.edu.co.response;

public class CursoResponseRest extends ResponseRest{

    private CursoResponse cursoResponse = new CursoResponse();

    public CursoResponse getCursoResponse() {
        return cursoResponse;
    }

    public void setCursoResponse(CursoResponse cursoResponse) {
        this.cursoResponse = cursoResponse;
    }
}