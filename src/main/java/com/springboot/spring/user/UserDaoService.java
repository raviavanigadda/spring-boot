/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.spring.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ravilion
 */
//bean managed by spring
@Component
public class UserDaoService {
    
    public static List<User> users = new ArrayList<>();
    private static int usersCount =3;
    
    static {
    users.add(new User(1,"Adam",new Date()));
    users.add(new User(2,"Eve",new Date()));
    users.add(new User(3,"Jack",new Date()));
    }
    
    public List<User> findAll(){
        return users;
    }
    
    public User save(User user){
    if(user.getId()==null)
    {
     user.setId(++usersCount);
    }
    users.add(user);
   
    return user;
    }
    
    public User findOne(int id){
    for(User user: users)
        if(user.getId() == id)
        {
        return user;
        }
     return null;   
    }
}
