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
                double definitiva = 0.0F;
                int size = estudiante.getNotas().size();
                if(size == 5) size--;
                for(int i = 0; i < size; i++){
                    definitiva += estudiante.getNotas().get(i);
                }

                if(estudiante.getNotas().size() == 5){
                    estudiante.getNotas().set(4, definitiva/4);
                }else{
                    estudiante.getNotas().add(definitiva/4);
                }

                mapper.save(estudiante);
                return estudiante;
        }
        return null;
    }

}
