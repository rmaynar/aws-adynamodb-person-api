package com.maynar.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBDocument
public class Address implements Serializable {

    private static final long serialVersionUID = 5701175728775683073L;

    @DynamoDBAttribute
    private String street;

    @DynamoDBAttribute
    private int number;

    @DynamoDBAttribute
    private int postCode;

    @DynamoDBAttribute
    private String city;

    @DynamoDBAttribute
    private String country;
}
