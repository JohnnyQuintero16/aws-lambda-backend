package com.aws.lambda.estudiante;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler implements RequestHandler<Request, Object> {

    @Override
    public Object handleRequest(Request request, Context context) {

        AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        Estudiante estudiante = null;

       switch (request.getHttpMethod()) {
            case "GET":
                if (request.getId() == 0) {
                    List<Estudiante> estudiantes = new ArrayList<>();
                    estudiantes = mapper.scan(Estudiante.class, new DynamoDBScanExpression());
                    return estudiantes;
                } else {
                    estudiante = mapper.load(Estudiante.class, request.getId());
                    return estudiante;
                }

            case "PUT":
                estudiante = request.getEstudiante();
                mapper.save(estudiante);
                return estudiante;

            case "DELETE":
                estudiante = mapper.load(Estudiante.class, request.getId());
                if (estudiante != null)
                    mapper.delete(estudiante);
                return estudiante;
        }
        return null;
    }

}
