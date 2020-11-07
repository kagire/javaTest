package com.mastery.simplewebapp.dto;

import java.util.List;
import java.util.Random;

public enum Gender {
    MALE,
    FEMALE;

    //to pick rand enum
    public static Gender randomGender(){
        final List<Gender> value = List.of(values());
        final int length = value.size();
        final Random RANDOM = new Random();
        return value.get(RANDOM.nextInt(length));
    }
}