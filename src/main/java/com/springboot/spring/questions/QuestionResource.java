/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.spring.questions;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author ravilion
 */

@RestController
public class QuestionResource {
    
    @Autowired
    private QuestionDaoService questionService;
    
    //http://localhost:9090/questions
   @GetMapping(path = "/questions")
    public List<Question> showAll(){
         return questionService.listAll();
    }
    
    @GetMapping("/questionslist{id}")
    public Question retrieveQuestion(@PathVariable int id){
    Question question = this.questionService.findOne(id);
    
    if(question == null)
    {
        throw new QuestionNotFoundException("id-"+ id);
    }
   
    return question;
    }
    
    //Post and save new questionService
    //http://localhost:9090/questionsave
    @PostMapping("/questionsave")
    public  ResponseEntity<Object> createQuestion(@RequestBody Question question)
    {
        Question savedQuestion = this.questionService.save(question);
        
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedQuestion.getQuestionID()).
                toUri();   
       return ResponseEntity.created(location).build();
        
    }
    
    //delete
    @GetMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable int id){
    Question question = questionService.DeleteById(id);
    
    if(question == null)
    {
        throw new QuestionNotFoundException("id-"+ id);
    }
    
    }
    
}