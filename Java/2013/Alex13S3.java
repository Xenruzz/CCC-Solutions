//Alex
//2013 S3
//https://cemc.uwaterloo.ca/contests/computing/2013/stage1/seniorEn.pdf
//60/80 (DMOJ) (Incomplete - To Be Reviewed)

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int specific_team = Integer.parseInt(br.readLine()) - 1;
        int num_games_played = Integer.parseInt(br.readLine());

        boolean[][] matches_marked = new boolean[4][4];

        int[] team_score = new int[4];

        for (int i = 0; i < num_games_played; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken()) - 1;
            int t2 = Integer.parseInt(st.nextToken()) - 1;
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            //sorts so that t1 is always the smaller team number
            if (t1 > t2) {
                int temp = t1;
                t1 = t2;
                t2 = temp;

                temp = s1;
                s1 = s2;
                s2 = temp;

            }

            matches_marked[t1][t2] = true;

            if (s1 > s2) team_score[t1] += 3;
            else if (s2 > s1) team_score[t2] += 3;
            else {
                team_score[t1]++; team_score[t2]++;
            }
        }

        System.out.println(recurse_count(team_score, matches_marked, num_games_played, specific_team));
    }

    public static int recurse_count(int[] team_score, boolean[][] matches_marked, int matches_completed, int specific_team) {
        int count = 0;
        if (matches_completed == 6) {
            if (winning_team(team_score) == specific_team) {
                return 1;
            }
            return 0;
        }


        //i = t1, j = t2
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (!matches_marked[i][j]) {
                    matches_marked[i][j] = true;

                    //if t1 wins and t2 loses
                    team_score[i] += 3;
                    count += recurse_count(team_score, matches_marked, matches_completed + 1, specific_team);
                    //reset
                    team_score[i] -= 3;

                    //if t2 wins and t1 loses
                    team_score[j] += 3;
                    count += recurse_count(team_score, matches_marked, matches_completed + 1, specific_team);
                    //reset
                    team_score[j] -= 3;

                    //if tie
                    team_score[i]++;
                    team_score[j]++;
                    count += recurse_count(team_score, matches_marked, matches_completed + 1, specific_team);
                    team_score[i]--;
                    team_score[j]--;

                    matches_marked[i][j] = false;
                    return count;
                }
            }
        }

        return count;
    }

    public static int winning_team(int[] scores) {
        int highest = 0;
        int highest_count = 0;
        for (int i = 1; i < 4; i++) {
            if (scores[i] > scores[highest]) {
                highest = i;
                highest_count = 1;
            }
            else if (scores[i] == scores[highest]) highest_count++;

        }

        if (highest_count == 1) return highest;
        return -1;
    }
}
