package com.aws.lambda.dynamocrud;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "materia")
public class Materia {

    @DynamoDBHashKey
    private int id;

    @DynamoDBAttribute
    private String nombreMateria;

    public Materia() {

    }

    public Materia(int id, String nombreMateria) {
        this.id = id;
        this.nombreMateria = nombreMateria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
}


