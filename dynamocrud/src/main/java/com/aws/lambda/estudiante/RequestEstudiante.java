package com.aws.lambda.estudiante;

public class RequestEstudiante {
    private  int id;

    private String httpMethod;

    private Estudiante estudiante;

    public RequestEstudiante() {
    }

    public RequestEstudiante(int id, String httpMethod, Estudiante estudiante) {
        this.id = id;
        this.httpMethod = httpMethod;
        this.estudiante = estudiante;
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
