//Alex
//2013 S1
//https://cemc.uwaterloo.ca/contests/computing/2013/stage1/seniorEn.pdf
//15/15 (Brute force works I guess)

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(br.readLine());

        while (!is_distinct(++start));

        System.out.println(start);
    }

    public static boolean is_distinct(int num) {
        String s_num = num + "";
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < s_num.length(); i++) {
            char c = s_num.charAt(i);
            if (used.contains(c)) return false;

            used.add(c);
        }

        return true;
    }
}
