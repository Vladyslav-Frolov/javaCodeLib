package com.spring.integration.service;

import com.spring.integration.model.Animal;
import org.springframework.stereotype.Service;

@Service("aService")
public class A {
    public Animal process(Animal animal) {
        System.out.println("A is processing animal");
        return animal;
    }
}
