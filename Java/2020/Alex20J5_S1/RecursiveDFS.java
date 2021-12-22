//Alex
//2020 J5/S2
//https://cemc.uwaterloo.ca/contests/computing/2020/ccc/juniorEF.pdf
//13/15 
//Recursive Method
//TLE (and clipped output???) at Batch #7 Case #6

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x, y;
        public Point(int x, int y) {this.x = x; this.y = y;}
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num_col = Integer.parseInt(br.readLine());
        int num_row = Integer.parseInt(br.readLine());
        int[][] values = new int[num_col][num_row];

        for (int i = 0; i < num_col; i++) {
            values[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }

        boolean[][] passed = new boolean[num_col][num_row];

        HashMap<Integer, ArrayList<Point>> keys = getKeys(num_col, num_row);
        //note that point coords aren't 0 based

        boolean good = traverse(new Point(1, 1), values, keys, passed);

        if (good) System.out.println("yes");
        else System.out.println("no");
    }

    public static boolean traverse(Point current, int[][] values, HashMap<Integer, ArrayList<Point>> keys, boolean[][] passed) {
        if (current.x == passed.length && current.y == passed[0].length) return true;

        int x = current.x;
        int y = current.y;

        int value = values[x - 1][y - 1];
        if (passed[x - 1][y - 1]) return false;
        passed[x - 1][y - 1] = true;

        ArrayList<Point> points = keys.getOrDefault(value, null);

        if (points == null) return false;

        for (Point point: points) {
            boolean gucci = traverse(point, values, keys, passed);
            if (gucci) return true;

        }

        return false;
    }

    public static HashMap<Integer, ArrayList<Point>> getKeys(int num_col, int num_row) {
        HashMap<Integer, ArrayList<Point>> map = new HashMap<>();
        for (int x = 1; x <= num_col; x++) {
            for (int y = 1; y <= num_row; y++) {
                ArrayList<Point> temp = map.getOrDefault(x*y, new ArrayList<>());
                temp.add(new Point(x, y));
                map.put(x*y, temp);
                
            }
        }
        
        return map;
    }
}
