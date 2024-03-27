package org.acme.sao;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    
    public String greeting(String name) {
        System.out.println("name was" + name);
        return "hello " + name;
    }
}
