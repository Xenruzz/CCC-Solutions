//Alex
//2011 S1
//https://cemc.uwaterloo.ca/contests/computing/2011/stage1/seniorEn.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (is_french(br, n)) System.out.println("French");
        else System.out.println("English");
    }

    public static boolean is_french(BufferedReader br, int n) throws IOException {
        int t_count = 0, s_count = 0;

        for (int j = 0; j < n; j++) {
            String s = br.readLine();
            s = s.toLowerCase();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 't') t_count++;
                if (c == 's') s_count++;

            }
        }

        return s_count >= t_count;
    }
}
