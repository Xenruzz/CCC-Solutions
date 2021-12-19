//Alex
//2019 J4/S1
//https://cemc.uwaterloo.ca/contests/computing/2019/stage%201/juniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        boolean v = false, h = false;

        for (char a: input) {
            if (a == 'V') v = !v;
            else h = !h;

        }

        int top_left = 1;
        int top_right = 2;
        int bot_left = 3;
        int bot_right = 4;

        int temp;
        if (h) {
            temp = top_left;
            top_left = bot_left;
            bot_left = temp;

            temp = top_right;
            top_right = bot_right;
            bot_right = temp;

        }

        if (v) {
            temp = top_left;
            top_left = top_right;
            top_right = temp;

            temp = bot_left;
            bot_left = bot_right;
            bot_right = temp;

        }

        System.out.println(top_left + " " + top_right + "\n" + bot_left + " " + bot_right);
    }
}
