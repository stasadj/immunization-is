package com.immunization.portal.util;

import java.util.Random;

public class NumberStringGenerator {
    private NumberStringGenerator() { }

    private static String DIGITS = "0123456789";
    private static Random RANDOM = new Random();
    
    public static String generateNumberSequence(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        }
        
        return sb.toString();
    }
}
