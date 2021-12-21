//Alex
//2021 S1
//https://cemc.uwaterloo.ca/contests/computing/2021/ccc/seniorEF.pdf
//15/15
package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        double area = 0;

        int[] h = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] w = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < w.length; i++) {
            area += ((double)w[i]) * (h[i] + h[i + 1]) / 2;

        }

        System.out.println(area);
    }
}
