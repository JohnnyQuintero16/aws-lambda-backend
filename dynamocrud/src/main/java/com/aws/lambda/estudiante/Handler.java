package com.aws.lambda.estudiante;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Handler implements RequestHandler<RequestEstudiante, Object> {

    @Override
    public Object handleRequest(RequestEstudiante request, Context context) {

        AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        Estudiante estudiante = null;

       switch (request.getHttpMethod()) {
            case "GET":
                List<Estudiante> estudianteList = new ArrayList<>();
                estudianteList = mapper.scan(Estudiante.class, new DynamoDBScanExpression());
                return estudianteList.stream().filter(estu -> estu.getIdMateria() == request.getId()).collect(Collectors.toList());
            case "POST":
                estudiante = request.getEstudiante();
                mapper.save(estudiante);
                return estudiante;
        }
        return null;
    }

}
