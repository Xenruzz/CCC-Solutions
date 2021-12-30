//Alex
//2011 S2
//https://dmoj.ca/submission/4154811
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] input = new char[n];

        for (int i = 0; i < n; i++) {
            input[i] = br.readLine().charAt(0);

        }

        int count = 0;
        for (int i = 0; i < n; i++) if (br.readLine().charAt(0) == input[i]) count++;

        System.out.println(count);
    }
}
