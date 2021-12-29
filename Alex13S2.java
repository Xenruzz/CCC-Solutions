//Alex
//2013 S2
//https://cemc.uwaterloo.ca/contests/computing/2013/stage1/seniorEn.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int w = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        System.out.println(weight_check(br, n, w));
    }

    public static int weight_check(BufferedReader br, int n, int w) throws IOException {
        int sum = 0;
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(br.readLine());

            if (i < 4) {
                sum += weights[i];

            } else {
                sum += weights[i];
                sum -= weights[i - 4];

            }

            if (sum > w) {
                return i;

            }
        }

        return n;
    }
}
