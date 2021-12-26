//Alex
//2017 J5/S3
//https://cemc.uwaterloo.ca/contests/computing/2018/stage%201/seniorEF.pdf
//15/15

package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //counts all the heights from the input (the index is the height)
        int[] board_height_count = new int[2001];
        //counts all the heights (of combinations) and stores the length
        int[] combination_height_count = new int[4001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            board_height_count[Integer.parseInt(st.nextToken())]++;

        }

        for (int first_height = 1; first_height <= 2000; first_height++) {
            int first_height_count =board_height_count[first_height];
            if (first_height_count != 0) {
                for (int second_height = first_height; second_height <= 2000; second_height++) {
                    int combination_height = first_height + second_height;
                    if (second_height == first_height) {
                        combination_height_count[combination_height] += board_height_count[second_height] / 2;

                    } else {
                        int second_height_count = board_height_count[second_height];
                        combination_height_count[combination_height] += Math.min(first_height_count, second_height_count);

                    }
                }
            }
        }

        int largest_length = -1;
        int unique_heights = -1;

        for (int height = 0; height < 4000; height++) {
            int temp_length = combination_height_count[height];
            if (temp_length > largest_length) {
                largest_length = temp_length;
                unique_heights = 1;

            } else if (temp_length == largest_length) {
                unique_heights++;

            }
        }

        System.out.println(largest_length + " " + unique_heights);
    }
}
