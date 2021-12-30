//Alex
//2013 S4
//https://cemc.uwaterloo.ca/contests/computing/2013/stage1/seniorEn.pdf
//?/15 (80/300 DMOJ) (13/15 CCC)

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, ArrayList<Integer>> person_shorter = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            ArrayList<Integer> people_list = person_shorter.getOrDefault(p1, new ArrayList<>());
            people_list.add(p2);

            person_shorter.put(p1, people_list);

        }

        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        if (is_taller(p1, p2, person_shorter, n)) System.out.println("yes");
        else if (is_taller(p2, p1, person_shorter, n)) System.out.println("no");
        else System.out.println("unknown");
    }

    public static boolean is_taller(int p1, int p2, HashMap<Integer, ArrayList<Integer>> person_shorter, int n) {
        boolean[] marked = new boolean[n + 1];
        marked[p1] = true;
        ArrayList<Integer> main_list = person_shorter.getOrDefault(p1, new ArrayList<>());

        while (!main_list.isEmpty()) {
            int temp_person = main_list.remove(0);

            if (marked[temp_person]) continue;
            if (temp_person == p2) return true;

            main_list.addAll(person_shorter.getOrDefault(temp_person, new ArrayList<>()));
        }

        return false;
    }
}
