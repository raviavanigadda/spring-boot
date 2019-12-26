
package com.springboot.spring.helloworld;

import com.springboot.spring.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ravilion
 */

@RestController
public class HelloWorld {
    
    @GetMapping(path = "/hello")
    public String HelloWorld(){
    return "Hello baby";
    }
   
@GetMapping("/worlds")
    public HelloWorldBean hwb(){
    return new HelloWorldBean("Hello World");
    }
    
//http://localhost:9090/helloworldbean#
    @GetMapping(path = "/helloworld/{name}")
    public HelloWorldBean hwb(@PathVariable String name){
    return new HelloWorldBean(String.format("Hello World, %s",name));
    }
    
}
