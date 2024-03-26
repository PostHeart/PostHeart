package com.example.postheart.registration;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class EmailValidator implements Predicate<String>{

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@(.+)$"
    );

    @Override
    public boolean test(String t) {
    
       return EMAIL_PATTERN.matcher(t).matches();
    }

}
