//Alex
//2011 S3
//https://cemc.uwaterloo.ca/contests/computing/2011/stage1/seniorEn.pdf
//50/50 (DMOJ)

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            System.out.println(recurse_check_crystal(m, ++x, ++y));

        }
    }

    public static String recurse_check_crystal(int m, long x, long y) {
        if (m == 0) return "empty";

        long curr_size = (long)Math.pow(5, m);
        long prev_size = (long)Math.pow(5, m - 1);

        //out of bounds
        if (x < prev_size || x > curr_size - prev_size) return "empty";

        //if in the left or right 1x1 squares
        if ((x > prev_size && x < 2 * prev_size + 1) || (x > 3 * prev_size && x < 4 * prev_size + 1)) {
            if (y > 2 * prev_size) return "empty";
            if (y <= prev_size) return "crystal";

        } else if (x > 2 * prev_size && x < 4 * prev_size) { //if in the central 1x2 rectangle
            if (y > 3 * prev_size) return "empty";
            if (y <= 2 * prev_size) return "crystal";

        }

        long new_x = x % prev_size;
        long new_y = y % prev_size;

        return recurse_check_crystal(m - 1, new_x, new_y);
    }
}
