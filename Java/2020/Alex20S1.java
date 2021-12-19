//Alex
//2020 S1
//https://cemc.uwaterloo.ca/contests/computing/2020/ccc/seniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> time_pos = new HashMap<>();
        int[] times = new int[n];
        String[] split;
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            times[i] = Integer.parseInt(split[0]);
            time_pos.put(times[i], Integer.parseInt(split[1]));

        }

        double fastest = 0;
        Arrays.sort(times);

        int next_time = times[0], next_pos = time_pos.get(next_time);
        int curr_time, curr_pos;
        for (int i = 0; i < n - 1; i++) {
            curr_time = next_time;
            curr_pos = next_pos;

            next_time = times[i + 1];
            next_pos = time_pos.get(next_time);

            double speed = Math.abs((double)next_pos - curr_pos)/(next_time - curr_time);

            fastest = Math.max(speed, fastest);
        }

        System.out.printf("%.5f", fastest);
    }
}
