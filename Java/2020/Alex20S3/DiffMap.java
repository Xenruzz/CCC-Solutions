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

        HashMap<Character, Integer> count_map;
        HashMap<Character, Integer> diff_map = new HashMap<>();

        for (int i = 0; i < h.length() - n.length() + 1; i++) {
            String sub = h.substring(i, i + n.length());

            if (i == 0) {
                count_map = countLetters(sub);
                diff_map = getDiffMap(n_map, count_map);

            } else {
                char old = h.charAt(i - 1);
                char latest = h.charAt(i + n.length() - 1);

                if (n_map.containsKey(old)) {
                    diff_map.put(old, diff_map.getOrDefault(old, 0) - 1);
                    if (diff_map.get(old) == 0) diff_map.remove(old);

                }

                if (n_map.containsKey(latest)) {
                    diff_map.put(latest, diff_map.getOrDefault(latest, 0) + 1);
                    if (diff_map.get(latest) == 0) diff_map.remove(latest);

                }
            }

            if (marked.contains(sub)) continue;

            if (diff_map.isEmpty()) {
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

    public static HashMap<Character, Integer> getDiffMap(HashMap<Character, Integer> n_map, HashMap<Character, Integer> count_map) {
        HashMap<Character, Integer> diff_map = new HashMap<>();
        for (char key : n_map.keySet()) {
            diff_map.put(key, count_map.getOrDefault(key, 0) - n_map.get(key));
            if (diff_map.get(key) == 0) diff_map.remove(key);


        }

        return diff_map;
    }
}
