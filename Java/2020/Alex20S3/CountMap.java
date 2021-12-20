//Alex
//2020 S3
//https://cemc.uwaterloo.ca/contests/computing/2020/ccc/seniorEF.pdf
//7/20 - TLE Batch #4 Case #12

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

        HashMap<Character, Integer> count_map = new HashMap<>();

        for (int i = 0; i < h.length() - n.length() + 1; i++) {
            String sub = h.substring(i, i + n.length());

            if (i == 0) {
                count_map = countLetters(sub);

            } else {
                char old = h.charAt(i - 1);
                char latest = h.charAt(i + n.length() - 1);

                count_map.put(old, count_map.getOrDefault(old, 0) - 1);

                if(count_map.get(old) == 0) count_map.remove(old);

                count_map.put(latest, count_map.getOrDefault(latest, 0) + 1);
            }

            if (marked.contains(sub)) continue;

            if (count_map.equals(n_map)) {
                marked.add(sub);
                count++;

            }
        }

        System.out.println(count);
    }

    public static HashMap<Character, Integer> countLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        for (char letter : array) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);

        }

        return map;
    }
}
