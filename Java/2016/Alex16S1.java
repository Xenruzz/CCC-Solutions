//Alex
//2016 S1
//https://www.cemc.uwaterloo.ca/contests/computing/2016/stage%201/seniorEn.pdf
//15/15
package com.company;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        if (a.length() != b.length()) {
            System.out.println("N");
            return;
        }

        HashMap<Character, Integer> countA = countLetters(a);
        HashMap<Character, Integer> countB = countLetters(b);

        int numWC = countB.getOrDefault('*', 0);
        int countWC = 0;

        int numA, numB;
        for (char letter: countA.keySet()) {
            numA = countA.get(letter);
            numB = countB.getOrDefault(letter, 0);

            if (numB > numA) {
                System.out.println("N");
                return;

            }

            if (numB < numA) {
                countWC += Math.abs(numA - numB);
                if (countWC > numWC) {
                    System.out.println("N");
                    return;

                }
            }

        }

        System.out.println("A");
    }

    public static HashMap<Character, Integer> countLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char letter: array) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);

        }

        return map;
    }
}
