//Alex
//2018 J4
//https://cemc.uwaterloo.ca/contests/computing/2018/stage%201/juniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] data = new int[n][n];

        for (int i = 0; i < n; i++) {
            data[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        }

        for (int i = 0; i < 4; i++) {
            data = rotate(data);

            int corner = data[0][0];
            int corner_right = data[0][1];
            int corner_down = data[1][0];
            int corner_corner = data[1][1];

            if ((corner < corner_right) && (corner < corner_down) && (corner_right < corner_corner)) {
                break;

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(data[i][j] + " ");

            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] data) {
        int n = data.length;

        int[][] output = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                output[j][n - i - 1] = data[i][j];

            }
        }

        return output;
    }
}
