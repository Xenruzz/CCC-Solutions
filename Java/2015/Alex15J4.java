//Alex
//2015 J4
//https://cemc.uwaterloo.ca/contests/computing/2015/stage%201/juniorEn.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] friends_receive_time = new int[101];
        int[] friends_waiting_time = new int[101];

        int time = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);

            if (type == 'W') {
                if (st.hasMoreTokens()) time += Integer.parseInt(st.nextToken()) - 1;
                continue;
            }

            int friend_num = Integer.parseInt(st.nextToken());
            if (type == 'R') friends_receive_time[friend_num] = time;
            else if (type == 'S') {
                int receive_time = friends_receive_time[friend_num];
                friends_waiting_time[friend_num] += time - receive_time;
                friends_receive_time[friend_num] = 0;
            }

            time++;
        }

        for (int i = 1; i < 101; i++) {
            if (friends_receive_time[i] != 0) System.out.println(i + " " + -1);
            else if (friends_waiting_time[i] != 0) System.out.println(i + " " + friends_waiting_time[i]);

        }
    }
}
