/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.spring.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ravilion
 */

@RestController
public class HelloWorld {
    
    @GetMapping(path = "/helloworld")
    public String HelloWorld(){
    return "Hello World";
    }
    
    @GetMapping(path = "/helloworldbean")
    public HelloWorldBean hwb(){
    return new HelloWorldBean("Hello World");
    }
//http://localhost:9090/helloworldbean#
    @GetMapping(path = "/helloworld/{name}")
    public HelloWorldBean hwb(@PathVariable String name){
    return new HelloWorldBean(String.format("Hello World, %s",name));
    }
    
}
