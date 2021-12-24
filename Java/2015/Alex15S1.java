//Alex
//2015 S1
//https://cemc.uwaterloo.ca/contests/computing/2015/stage%201/seniorEn.pdf
//15/15

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>(k);

        int sum = 0;

        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) {
                int prev = list.remove(list.size() - 1);
                sum -= prev;

            } else {
                list.add(temp);
                sum += temp;

            }
        }

        System.out.println(sum);
    }
}
