//Alex X
//2016 J5/S2
//https://www.cemc.uwaterloo.ca/contests/computing/2016/stage%201/juniorEn.pdf
//15/15
package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        //no idea how this works, copied from stack overflow lol
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(a);
        Arrays.sort(b);

        int rel = 0;
        if (q == 2) rel = n - 1; //we change this so that it's pulled in reverse

        int speed = 0;

        for (int i = 0; i < a.length; i++) {
            speed += Math.max(a[i], b[Math.abs(rel - i)]);

        }

        System.out.println(speed);
    }
}
