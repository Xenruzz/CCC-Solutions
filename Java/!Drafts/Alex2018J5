//Alex
//2018 J5
//https://cemc.uwaterloo.ca/contests/computing/2018/stage%201/juniorEF.pdf
//To Be Revised (Incomplete - Draft)

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] pages = new boolean[n];

        ArrayList<ArrayList<Integer>> page_paths = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            page_paths.add(new ArrayList(Arrays.asList(split)));

        }
    }

    public static void search(boolean[] pages, ArrayList<ArrayList<Integer>> page_paths) {
        int n = pages.length;
        int pages_left = n - 1;
        boolean completed = false;
        int step_count = 1;

        ArrayList<Integer> list = page_paths.get(0);
        Set<Integer> side_list = new HashSet<>();

        pages[0] = true;

        while (!list.isEmpty()) {
            int temp_page = list.remove(0);

            if (!pages[temp_page]) {
                pages[temp_page] = true;
                pages_left--;

                ArrayList<Integer> temp_list = page_paths.get(temp_page);

                if (temp_list.size() == 1) completed = true;

                side_list.addAll(page_paths.get(temp_page));

            }

            if (list.isEmpty() && !side_list.isEmpty()) {
                if (!completed) step_count++;

                list.addAll(side_list);

            }
        }

        if (completed) System.out.println("Y");
        else System.out.println("N");
        System.out.println(step_count);
    }
}
