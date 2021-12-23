//Alex
//2017 S2
//https://cemc.uwaterloo.ca/contests/computing/2017/stage%201/seniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(heights);
        int high_mid = n/2;
        int low_mid = n/2 - 1;

        //if low tide, start 1 higher because always 1 leftover, that is low tide
        if (n % 2 != 0) {high_mid++; low_mid++;}

        for (int i = 0; i < n/2; i++) {
            System.out.print(heights[low_mid--] + " " + heights[high_mid++] + " ");

        }

        //if odd number of heights, we always end on a low tide
        if (n % 2 != 0) System.out.print(heights[low_mid]);
    }
}
