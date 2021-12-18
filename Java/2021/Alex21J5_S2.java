//Alex
//2021 J5/S2
//https://www.cemc.uwaterloo.ca/contests/computing/2021/ccc/juniorEF.pdf
//15/15
package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

	    int r = Integer.parseInt(br.readLine());
	    int c = Integer.parseInt(br.readLine());

	    boolean[] rows = new boolean[r], cols = new boolean[c];

	    int n = Integer.parseInt(br.readLine());

	    String[] split;
	    char letter;
	    int num;

		int count_row = 0, count_col = 0;

	    for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            letter = split[0].charAt(0);
            num = Integer.parseInt(split[1]);
            num--;

            if (letter == 'R') {
            	if (rows[num]) count_row--;
            	else count_row++;

            	rows[num] = !rows[num];
			} else {
            	if (cols[num]) count_col--;
            	else count_col++;
            	cols[num] = !cols[num];
			}
        }

	    int gold_count = (count_row * c) + (count_col * r) - (2 * count_row * count_col);

	    System.out.println(gold_count);
    }
}
