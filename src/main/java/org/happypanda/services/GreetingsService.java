package org.happypanda.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingsService {

    public String greetings(String name) {
        return  "Hello " + name;
    }
}

