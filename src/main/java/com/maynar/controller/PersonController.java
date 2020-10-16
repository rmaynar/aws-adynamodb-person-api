package com.maynar.controller;

import com.maynar.entity.Person;
import com.maynar.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    /**
     * Saves a person
     * @param person
     * @return
     */
    @PostMapping
    public Person save(@RequestBody Person person){
        return personRepository.save(person);
    }

    /**
     * Gets a person
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable String id){
        return personRepository.findById(id);
    }

    /**
     * Updates a person
     * @param person
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Person person){
        return personRepository.update(person);
    }

    /**
     * Deletes a person
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        Person p = new Person();
        p.setId(id);
        personRepository.delete(p);
    }
}
