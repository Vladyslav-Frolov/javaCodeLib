package com.spring.integration.service;

import com.spring.integration.model.Animal;
import org.springframework.stereotype.Service;

@Service("bService")
public class B {
    public Animal process(Animal animal){
        System.out.println("B is processing animal");
        return animal;
    }
}
