//Alex
//2015 S3
//https://cemc.uwaterloo.ca/contests/computing/2015/stage%201/seniorEn.pdf
//15/30 (DMOJ)
//15/15 (CCC)

package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num_gates = Integer.parseInt(br.readLine());
        int num_planes = Integer.parseInt(br.readLine());

        int planes_good = 0;

        boolean[] gate_status = new boolean[num_gates];

        boolean got_answer = false;

        for (int i = 0; i < num_planes; i++) {
            if (got_answer) {
                br.readLine();
                continue;

            }

            int gate_num = Integer.parseInt(br.readLine()) - 1;

            while (gate_num >= 0 && gate_status[gate_num]) gate_num--;

            if (gate_num < 0) {got_answer = true; continue;}

            planes_good++;

            gate_status[gate_num] = true;
        }

        System.out.println(planes_good);
    }
}
