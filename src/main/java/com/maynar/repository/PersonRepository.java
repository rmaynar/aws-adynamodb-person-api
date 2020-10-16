package com.maynar.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.maynar.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {


    @Autowired
    private DynamoDBMapper mapper;

    /**
     * Saves a person
     * @param person
     * @return
     */
    public Person save(Person person){
        mapper.save(person);
        return person;
    }

    /**
     * Deletes a person
     * @param person
     */
    public void delete(Person person){
        mapper.delete(person);
    }

    /**
     * Returns the person
     * @param id
     * @return
     */
    public Person findById(String id){
        return mapper.load(Person.class, id);
    }

    /**
     * Updates a person
     * @param person
     * @return
     */
    public String update(Person person){
        mapper.save(person, saveExpression(person));
        return "Updated succesfully!";
    }

    private DynamoDBSaveExpression saveExpression(Person person){
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("id", new ExpectedAttributeValue(new AttributeValue(person.getId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }
}
