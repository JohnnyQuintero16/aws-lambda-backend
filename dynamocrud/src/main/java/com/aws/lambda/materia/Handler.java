package com.aws.lambda.materia;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.List;

public class Handler implements RequestHandler<RequestMateria, Object> {

    @Override
    public Object handleRequest(RequestMateria request, Context context) {

        AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        Materia materia = new Materia();

        switch (request.getHttpMethod()) {
            case "GET":
                if (request.getId() == 0) {
                    List<Materia> materias = new ArrayList<>();
                    materias = mapper.scan(Materia.class, new DynamoDBScanExpression());
                    return materias;
                } else {
                    materia = mapper.load(Materia.class, request.getId());
                    return materia;
                }
            case "POST":
                materia = request.getMateria();
                mapper.save(materia);
                return request;
            case "DELETE":
                materia = mapper.load(Materia.class, request.getId());
                mapper.delete(materia);
                return materia;
        }
        return null;
    }
}
