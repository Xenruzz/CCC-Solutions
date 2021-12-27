//Alex
//2017 J4
//https://cemc.uwaterloo.ca/contests/computing/2017/stage%201/juniorEF.pdf
//15/15

package com.company;

import java.io.*;
import java.util.*;

/*
 * 1234
 *
 * 0111
 * 0123
 * 0135
 * 0147
 * 0159
 *
 * 0210
 * 0222
 * 0234
 * 0246
 * 0258
 *
 * 0321
 * 0333
 * 0345
 * 0357
 *
 * 0420
 * 0432
 * 0444
 * 0456
 *
 * 0531
 * 0543
 * 0555
 *
 * 0630
 * 0642
 * 0654
 *
 * 0741
 * 0753
 * 0765
 *
 * 0840
 *
 * 0951
 *
 * 1111
 *
 * 1234
 *
 * 31 unique sequences per cycle (12 hour)
 */
public class Main {

    static class Clock {
        int h;
        int m1, m2;

        public Clock() {
            h = 12;
            m1 = 0;
            m2 = 0;

        }

        public void increment() {
            if (++m2 == 10) {
                m2 = 0;
                if (++m1 == 6) {
                    m1 = 0;
                    if (++h == 13) h = 1;
                }
            }
        }

        public int sum_time() {
            int new_h = h;
            if (new_h == 12) new_h = 0;
            return (new_h * 60) + (m1 * 10) + m2;

        }

        public boolean check_pattern() {
            if (h == 10) return false;
            if (h == 11) {
                if (m1 == 1 && m2 == 1) return true;
                return false;
            }

            if (h == 12) {
                if (m1 == 3 && m2 == 4) return true;
                return false;
            }

            if (h - m1 == m1 - m2) return true;
            return false;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long time = Long.parseLong(br.readLine());
        long full_cycles = time/60/12;
        long count = full_cycles * 31;

        long leftover_time = time % (60 * 12);

        Clock c = new Clock();

        while (c.sum_time() <= leftover_time) {
            boolean gucci = c.check_pattern();
            if (gucci) {
                count++;
            }
            c.increment();
        }

        System.out.println(count);
    }
}
