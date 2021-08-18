package com.springboot.virtualexam.util;

import java.util.Random;

public class StringManipulation {

    public static String generationId(char initialId, String word){
        char firstLetter = word.charAt(0);
        int random = new Random()
                .ints(0, 999)
                .findFirst()
                .getAsInt();

        StringBuilder creatingIdentifier = new StringBuilder();
        creatingIdentifier.append(initialId);
        creatingIdentifier.append(firstLetter);
        creatingIdentifier.append(random);

        return creatingIdentifier.toString();
    }

}
