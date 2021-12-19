//Alex
//2020 S3
//https://cemc.uwaterloo.ca/contests/computing/2020/ccc/seniorEF.pdf
//7/20 - TLE Batch #4 Case #7

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        String h = br.readLine();

        HashMap<Character, Integer> n_map = countLetters(n);
        Set<String> marked = new HashSet<>();

        int count = 0;
        for (int i = 0; i < h.length() - n.length() + 1; i++) {
            String sub = h.substring(i, i + n.length());

            if (marked.contains(sub)) continue;

            HashMap<Character, Integer> sub_map = countLetters(sub);

            if (sub_map.equals(n_map)) {
                marked.add(sub);
                count++;
            }
        }

        System.out.println(count);
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
