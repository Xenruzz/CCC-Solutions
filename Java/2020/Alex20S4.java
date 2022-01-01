//Alex
//2020 S4
//https://cemc.uwaterloo.ca/contests/computing/2020/ccc/seniorEF.pdf
//15/15

package com.company;

/*
 * ABC
 * BCA
 * CAB
 *
 * CBA
 * BAC
 * ACB
 *
 * ABC
 * ACB
 *
 * BAC
 * BCA
 *
 * CAB
 * CBA
 */

import java.util.*;
import java.io.*;

public class Main {

    static HashMap<Character, Integer> letter_count = new HashMap<>();
    static HashMap<Character, Integer> section_1 = new HashMap<>();
    static HashMap<Character, Integer> section_2 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        section_1.put('A', 0);
        section_2.put('A', 0);
        section_1.put('B', 0);
        section_2.put('B', 0);
        section_1.put('C', 0);
        section_2.put('C', 0);

        letter_count.put('A', 0);
        letter_count.put('B', 0);
        letter_count.put('C', 0);

        count_letters(input);

        int count_abc = sliding_panel('A', 'B', 'C', input);

        section_1.put('A', 0);
        section_2.put('A', 0);
        section_1.put('B', 0);
        section_2.put('B', 0);
        section_1.put('C', 0);
        section_2.put('C', 0);

        int count_cba = sliding_panel('C', 'B', 'A', input);

        System.out.println(Math.min(count_abc, count_cba));
    }

    public static int sliding_panel(char c_1, char c_2, char c_3, char[] input) {
        //section_1 corresponds with c_1, and section_2 corresponds with c_2
        int n = input.length;
        int count_1 = letter_count.get(c_1);
        int count_2 = letter_count.get(c_2);

        int best = Integer.MAX_VALUE - 1;

        for (int i = 0; i < n; i++) {
           if (i == 0) { //create the initial window/panel
               for (int j = 0; j < count_1 + count_2; j++) {
                   char c = input[j];
                   if (j < count_1) section_1.put(c, section_1.get(c) + 1);
                   else section_2.put(c, section_2.get(c) + 1);

               }
           }
           else { //slide the panel over
               char old_1 = input[i - 1];
               char old_2 = input[(i + count_1 - 1) % n];

               char new_1 = old_2; //the last of section 2 becomes the first of section 1
               char new_2 = input[(i + count_1 + count_2 - 1) % n]; //the last of section 3 becomes the first of section 2

               section_1.put(old_1, section_1.get(old_1) - 1);
               section_2.put(old_2, section_2.get(old_2) - 1);

               section_1.put(new_1, section_1.get(new_1) + 1);
               section_2.put(new_2, section_2.get(new_2) + 1);
           }

           int count = section_1.get(c_2) + section_1.get(c_3) + section_2.get(c_1) + section_2.get(c_3) - Math.min(section_1.get(c_2), section_2.get(c_1));
           best = Math.min(best, count);
        }

        return best;
    }

    public static void count_letters(char[] input) {
        for (char c: input) {
            letter_count.put(c, letter_count.get(c) + 1);

        }
    }
}
