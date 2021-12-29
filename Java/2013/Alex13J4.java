//Alex
//2013 J4
//https://cemc.uwaterloo.ca/contests/computing/2013/stage1/juniorEn.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int sum = 0;
        int count = 0;
        while (sum <= t && count < n) {
            sum += nums[count++];

        }

        System.out.println(--count);
    }
}
