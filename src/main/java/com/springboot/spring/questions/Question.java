/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.spring.questions;

/**
 *
 * @author ravilion
 */

class Question {
    
    Integer questionID;
    String question;

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "Question{" + "questionID=" + questionID + ", question=" + question + '}';
    }

    public Question() {
    }

    public Question(Integer questionID, String question) {
        this.questionID = questionID;
        this.question = question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
}
