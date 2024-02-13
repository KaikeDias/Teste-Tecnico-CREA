package com.example.testetecnicocrea.common.utils;

import java.util.Random;

public class CodeGenerator {
    public static String generateCode() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 9; i++) {
            sb.append(rand.nextInt(10));
        }

        sb.append("PI");

        return sb.toString();
    }
}
