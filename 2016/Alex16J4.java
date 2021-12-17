//Alex
//2016 J4
//https://www.cemc.uwaterloo.ca/contests/computing/2016/stage%201/juniorEn.pdf
//15/15
package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    String[] split = br.readLine().split(":");
	    int first = Character.getNumericValue(split[0].charAt(0));

	    int h, m;

	    if (first == 0)  h = Character.getNumericValue(split[0].charAt(1));
	    else h = Integer.parseInt(split[0]);

	    first = Integer.valueOf(split[1].charAt(0));
	    if (first == 0) m = Integer.valueOf(split[0].charAt(1));
	    else m = Integer.parseInt(split[1]);


	    int minutes = h * 60 + m;
	    /*
	    rush hours:

	    7h = 420min
	    to
	    10h = 600min

	    15h = 900min
	    to
	    19h = 1140min
	     */

        int s1 = 420, e1 = 600;
        int s2 = 900, e2 = 1140;

        //t = time to go
        int t = 0;
        while (t < 120) {
            minutes += 10;
            minutes %= 1440;
            if (minutes > s1 && minutes < e1 || minutes > s2 && minutes < e2) {
                t += 5;

            } else {
                t+= 10;

            }
        }

        String min = String.valueOf(minutes % 60);
        String hour = String.valueOf(minutes / 60 % 24);
        if (min.length() == 1) min = "0" + min;
        if (hour.length() == 1) hour = "0" + hour;

        System.out.println(hour + ":" + min);
    }
}
