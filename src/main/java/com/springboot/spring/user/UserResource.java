/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.spring.user;

import com.springboot.spring.questions.QuestionNotFoundException;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
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
 * @author Ravilion
 */

@RestController
public class UserResource {
    
    @Autowired
    private UserDaoService service;
    
    //http://localhost:9090/users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
    return service.findAll();
    }
    
    @GetMapping("/user/{id}")
    public User retrieveUser(@PathVariable int id){
    User user = service.findOne(id);
    
    if(user == null)
    {
        throw new UserNotFoundException("id-"+ id);
    }
    
    return user;
    }
    
    //createUser i/o: deaisl of user
    //o/p: create and return the created URI
    @PostMapping("/usersave")
    public  ResponseEntity<Object> createUser(@Valid @RequestBody User user)
    {
        User savedUser = service.save(user);
        
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();
      
       return ResponseEntity.created(location).build();
        
    }
    
    @GetMapping("/users/{id}")
    public void deleteQuestion(@PathVariable int id){
    User user = service.DeleteById(id);
    
    if(user == null)
    {
        throw new QuestionNotFoundException("id-"+ id);
    }
    
   }
}
