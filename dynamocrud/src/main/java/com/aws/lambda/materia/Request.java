package com.aws.lambda.materia;

import com.aws.lambda.estudiante.Estudiante;

public class Request {

    private  int id;

    private String httpMethod;

    private Materia materia;

    public Request() {
    }

    public Request(int id, String httpMethod, Materia materia) {
        this.id = id;
        this.httpMethod = httpMethod;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Estudiante estudiante) {
        this.materia = materia;
    }
}
