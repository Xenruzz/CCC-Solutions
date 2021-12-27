//Alex
//2015 J5
//https://cemc.uwaterloo.ca/contests/computing/2015/stage%201/juniorEn.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static HashMap<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        System.out.println(recurse_count(n, k, 1));
    }

    public static long recurse_count(int n, int k, int min) {
        if (k == 1 || k == n) return 1;

        //int hash doesn't work
        String hash = n + " " + k + " " + min;

        if (memo.containsKey(hash)) return memo.get(hash);

        int count = 0;
        for (int i = min; i < n/k + 1; i++) {
            count += recurse_count(n - i, k - 1, i);

        }

        memo.put(hash, count);
        return count;
    }
}
