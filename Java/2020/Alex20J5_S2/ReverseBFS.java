//Alex
//2020 J5/S2
//https://cemc.uwaterloo.ca/contests/computing/2020/ccc/juniorEF.pdf
//11/15

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

        int num_rows = Integer.parseInt(br.readLine());

        int num_cols = Integer.parseInt(br.readLine());

        HashMap<Integer, ArrayList<Point>> value_points = new HashMap<>();

        for (int i = 0; i < num_rows; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num_cols; j++) {
                int temp_num = Integer.parseInt(st.nextToken());
                if (value_points.containsKey(temp_num)) value_points.get(temp_num).add(new Point(i, j));
                else {
                    ArrayList<Point> temp_list = new ArrayList<>();
                    temp_list.add(new Point(i, j));
                    value_points.put(temp_num, temp_list);
                }
            }
        }

        if (breadth_first_search(num_rows, num_cols, value_points)) System.out.println("yes");
        else System.out.println("no");
    }

    public static boolean breadth_first_search(int num_rows, int num_cols, HashMap<Integer, ArrayList<Point>> value_points) {
        boolean[][] marked = new boolean[num_rows][num_cols];
        marked[num_rows - 1][num_cols - 1] = true;
        boolean first = true;
        ArrayList<Point> list = new ArrayList<>(value_points.getOrDefault(num_rows * num_cols, new ArrayList<>()));

        while (!list.isEmpty()) {
            if (first) {
                first = false;
                for (Point p: list) {
                    int temp_r = p.r;
                    int temp_c = p.c;
                    if (temp_r == 0 && temp_c == 0) return true;
                    if (!marked[temp_r][temp_c]) {
                        marked[temp_r][temp_c] = true;

                    }
                }
            }

            Point temp_point = list.remove(0);
            int r = temp_point.r;
            int c = temp_point.c;

            ArrayList<Point> temp_list = value_points.getOrDefault((r + 1) * (c + 1), new ArrayList<>());

            for (Point p: temp_list) {
                int temp_r = p.r;
                int temp_c = p.c;
                if (temp_r == 0 && temp_c == 0) return true;
                if (!marked[temp_r][temp_c]) {
                    marked[temp_r][temp_c] = true;
                    list.add(p);

                }
            }
        }

        return false;
    }
}
