//Alex
//2021 J4
//https://cemc.uwaterloo.ca/contests/computing/2021/ccc/juniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

import static java.lang.Math.min;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        int l_count = 0, m_count = 0;

        for (char letter: input) {
            if (letter == 'L') l_count++;
            else if (letter == 'M') m_count++;

        }

        int bad = 0;
        int m_in_l = 0;
        for (int i = 0; i < l_count; i++) {
            if (input[i] != 'L') {bad++; if (input[i] == 'M') m_in_l++;}

        }

        int l_in_m = 0;
        for (int i = l_count; i < l_count + m_count; i++) {
            if (input[i] != 'M') {bad++; if (input[i] == 'L') l_in_m++;}

        }

        System.out.println(bad - min(m_in_l, l_in_m));
    }
}
