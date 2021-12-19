//Alex
//2020 J4
//https://cemc.uwaterloo.ca/contests/computing/2020/ccc/juniorEF.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();

        StringBuilder s = new StringBuilder(br.readLine());

        for (int i = 0; i < s.length(); i++) {
            if (t.contains(s)) {System.out.println("yes"); return;}
            s.append(s.charAt(0));
            s.deleteCharAt(0);

        }

        System.out.println("no");
    }
}
