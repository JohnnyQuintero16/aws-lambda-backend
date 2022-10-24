package com.aws.lambda.estudiante;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "estudiante")
public class Estudiante {

    @DynamoDBHashKey
    private int id;

    @DynamoDBAttribute
    private int idMateria;

    @DynamoDBAttribute
    private String nombre;

    @DynamoDBAttribute
    List<Double> notas = new ArrayList<Double>();

    public Estudiante() {

    }

    public Estudiante(int id, int idMateria, String nombre, List<Double> notas) {
        this.id = id;
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}
