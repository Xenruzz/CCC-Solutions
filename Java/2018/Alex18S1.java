//Alex
//2018 S1
//https://cemc.uwaterloo.ca/contests/computing/2018/stage%201/seniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            positions[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(positions);

        int previous_pos = positions[0];
        double previous_left_length = -1, previous_right_length;
        double smallest_length = Double.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int current_pos = positions[i];
            double mid = ((double)previous_pos + current_pos) / 2;
            previous_right_length = mid - previous_pos;
            if (i != 1) {
                smallest_length = Math.min(smallest_length, previous_left_length + previous_right_length);

            }

            previous_pos = current_pos;
            previous_left_length = previous_right_length;
        }

        System.out.printf("%.1f%n", smallest_length);
    }
}
