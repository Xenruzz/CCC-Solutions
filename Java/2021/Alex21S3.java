//Alex
//2021 S3
//https://cemc.uwaterloo.ca/contests/computing/2021/ccc/seniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static long getTime(int x, int[] p, int[] w, int[] d) {
        long time = 0;

        for (int i = 0; i < p.length; i++) {
            int pos = p[i];
            int range = d[i];

            int left = pos - range;
            int right = pos + range;

            if (x >= left && x <= right) continue;

            int shortest = Math.min(Math.abs(x - left), Math.abs(x - right));

            int speed = w[i];

            //if you implicitly cast to long it gives you wrong answer?
            time += ((long) speed) * shortest;
        }

        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        n = Integer.parseInt(br.readLine());

        int[] p = new int[n], w = new int[n], d = new int[n];

        String[] split;
        long most_l = Long.MAX_VALUE, most_r = -1;
        for (int i = 0; i < n; ++i) {
            split = br.readLine().split(" ");
            p[i] = Integer.parseInt(split[0]);
            w[i] = Integer.parseInt(split[1]);
            d[i] = Integer.parseInt(split[2]);

            if (p[i] < most_l) most_l = p[i];
            if (p[i] > most_r) most_r = p[i];
        }

        int l = (int) most_l, r = (int) most_r;
        long best = Long.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r)/2;
            long time_mid = getTime(mid, p, w, d);

            if (time_mid < best) best = time_mid;

            long time_left = getTime(mid - 1, p, w, d);
            long time_right = getTime(mid + 1, p, w, d);

            if (time_left > time_right) l = ++mid;
            else r = --mid;

        }

        System.out.println(best);
    }
}
