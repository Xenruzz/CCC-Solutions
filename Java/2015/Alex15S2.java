//Alex
//2015 S2
//https://cemc.uwaterloo.ca/contests/computing/2015/stage%201/seniorEn.pdf
//15/15

package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num_jerseys = Integer.parseInt(br.readLine());
        int num_players = Integer.parseInt(br.readLine());

        char[] num_size = new char[num_jerseys];

        for (int i = 0; i < num_jerseys; i++) {
            char temp_size = br.readLine().charAt(0);
            num_size[i] = temp_size;

        }

        int count = 0;

        for (int i = 0; i < num_players; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char temp_size = st.nextToken().charAt(0);
            int temp_num = Integer.parseInt(st.nextToken());

            boolean bool = check_size(temp_size, num_size[temp_num - 1]);

            if (bool) {
                //set the size of that jersey to 'Z' to mark that it has been taken
                count++;
                num_size[temp_num - 1] = 'Z';
            }
        }

        System.out.println(count);
    }

    public static boolean check_size(char size1, char size2) {
        if (size1 == 'S' && size2 != 'Z') return true;
        if (size1 == 'M' && (size2 == 'M' || size2 == 'L')) return true;
        return size1 == 'L' && size2 == 'L';

    }
}
