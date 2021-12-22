//Alex
//2019 S3
//https://cemc.uwaterloo.ca/contests/computing/2019/stage%201/seniorEF.pdf
//To Be Revised (Incomplete - Draft)

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[3][3];

        for (int i = 0; i < 3; ++i) {
            board[i] = br.readLine().split(" ");

        }

        make_valid(board);
        complete_board(board);
        print_board(board);
    }

    //------------------COMPLETE A VALID BOARD------------------//
    public static void complete_board(String[][] board) {
        int valid_col_num = find_valid_col(board);

        String[] valid_col = new String[3];

        for (int i = 0; i < 3; i++) {
            valid_col[i] = board[i][valid_col_num];

        }

        complete_sequence(valid_col);

        for (int i = 0; i < 3; i++) {
            board[i][valid_col_num] = valid_col[i];

        }

        for (int i = 0; i < 3; i++) {
            String[] row_arr = board[i];
            complete_sequence(row_arr);

        }
    }

    public static int find_valid_col(String[][] board) {
        for (int i = 0; i < 3; ++i) {
            int count = 0;
            for (int j = 0; j < 3; ++j) {
                if (board[j][i].equals("X")) count++;

            }

            if (count == 1) return i;
        }

        return -1;
    }

    public static boolean complete_sequence(String[] data) {
        if (!check_valid(data)) return false;

        for (int i = 0; i < 3; i++) {
            if (data[i].equals("X")) {
                int diff;
                if (i == 0) {
                    int val2 = Integer.parseInt(data[2]), val1 = Integer.parseInt(data[1]);
                    diff = val2 - val1;
                    data[0] = val1 - diff + "";
                    return true;
                } else if (i == 1) {
                    int val2 = Integer.parseInt(data[2]), val0 = Integer.parseInt(data[0]);
                    diff = (val2 - val0) / 2;
                    data[1] = val0 + diff + "";
                    return true;
                } else {
                    int val1 = Integer.parseInt(data[1]), val0 = Integer.parseInt(data[0]);
                    diff = val1 - val0;
                    data[3] = val1 + diff + "";
                    return true;
                }
            }
        }

        return false;
    }

    //------------------MAKE BOARD VALID------------------//
    public static void make_valid(String[][] board) {



    }
    
    public static void complete_to_best(String[][] board) {

        boolean change = true;

        int n = board.length;
        String[] temp = new String[3];

        while (change) {
            change = false;

            for (int i = 0; i < 3; i++) {
                if (complete_sequence(board[i])) change = true;

            }

            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    temp[j] = board[j][i];

                }

                if (complete_sequence(temp)) {
                    for (int j = 0; j < 3; ++j) {
                        board[j][i] = temp[j];

                    }

                    change = true;
                }
            }
        }
    }

    //------------------AUXILIARY------------------//
    public static boolean check_valid(String[] data) {
        return (!data[0].equals("X") && !data[1].equals("X")) || (!data[1].equals("X") && !data[2].equals("X")) || (!data[2].equals("X") && !data[0].equals("X"));

    }
    
    public static void print_board(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");

            }

            System.out.println();
        }

    }
}
