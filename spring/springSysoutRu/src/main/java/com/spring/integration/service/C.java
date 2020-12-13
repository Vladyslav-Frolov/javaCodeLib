package com.spring.integration.service;

import com.spring.integration.model.Animal;
import org.springframework.stereotype.Service;

@Service("cService")
public class C {
    public Animal process(Animal animal) {
        System.out.println("C is processing animal");
        return animal;
    }
}
