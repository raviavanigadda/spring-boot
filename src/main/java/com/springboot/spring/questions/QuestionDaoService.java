/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.spring.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author ravilion
 */

@Component
public class QuestionDaoService {
    private static List<Question> questions = new ArrayList<>(); 
    
    private static int questionsCount = 2;
    
    static {
        questions.add(new Question(1,"What is your favourite place to hang out?"));
        questions.add(new Question(2,"Which holiday destination would you like to go?"));
    }
    
    //LIST ALL QUESTIONS
    public List<Question> listAll(){
        return questions;
    }
    
    //LIST ONE QUESTION
    public Question findOne(int id){
    
        for(Question q:questions){
        if(q.getQuestionID() == id)
            {
            return q;
            }
        }
           return null;
    
    }
            
    //ADD QUESTION
    public Question save(Question q){
    if(q.getQuestionID() ==null)
        {
            q.setQuestionID(++questionsCount);
        }
        questions.add(q);
        return q;
    }
    
    //Delete ONE QUESTION
    public Question DeleteById(int id){
    Iterator<Question> iterator = questions.iterator();
        while(iterator.hasNext()){
       
            Question question = iterator.next();
            if(question.getQuestionID() == id)
            {
                iterator.remove();             
                return question;
            }
        }
           return null;
    
    }
}