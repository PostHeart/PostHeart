package com.example.postheart.registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String>{

    @Override
    public boolean test(String t) {
        //TODO VALIDATE EMAIL
        return true;
    }

}
