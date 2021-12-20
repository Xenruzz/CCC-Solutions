//Alex
//https://cemc.uwaterloo.ca/contests/computing/2019/stage%201/seniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] output = new String[n];

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());

            for (int j = 2; j < t; j++) {
                if (prime(j) && prime(2 * t - j)) {
                    output[i] = j + " " + (2 * t - j);
                    break;

                }
            }
        }

        for (String s: output) {
            System.out.println(s);
        }
    }
  
    public static boolean prime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i == 0) return false;

        }

        return true;
    }
}
