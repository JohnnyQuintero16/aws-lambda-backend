package com.aws.lambda.materia;

public class RequestMateria {

    private int id;
    private String httpMethod;
    private Materia materia;

    public RequestMateria() {
    }

    public RequestMateria(int id, String httpMethod, Materia materia) {
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

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
