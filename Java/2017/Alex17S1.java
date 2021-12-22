//Alex
//2017 S1
//https://cemc.uwaterloo.ca/contests/computing/2017/stage%201/seniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int best = 0;

        int n = Integer.parseInt(br.readLine());

        int[] scores_1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] scores_2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int team_1_sum = 0, team_2_sum = 0;
        for (int i = 0; i < n; i++) {
            int score_1 = scores_1[i];
            team_1_sum += score_1;

            int score_2 = scores_2[i];
            team_2_sum += score_2;

            if (team_1_sum == team_2_sum) best = Math.max(i + 1, best);

        }

        System.out.println(best);
    }
}
