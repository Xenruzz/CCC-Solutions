//Alex
//2018 J5
//https://cemc.uwaterloo.ca/contests/computing/2018/stage%201/juniorEF.pdf
//15/15 (some optimization could be done, however, this still works)

package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] pages_and_paths = new int[n][];

        for (int i = 0; i < n; i++) {
            pages_and_paths[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }

        bfs_search(n, pages_and_paths);

    }

    public static void bfs_search(int n, int[][] pages_and_paths) {
        boolean[] marked = new boolean[n];
        marked[0] = true;
        int count = 2;
        boolean stop_counting = false;

        ArrayList<Integer> main_list = new ArrayList<>(get_next_possible(pages_and_paths, marked, 1));
        ArrayList<Integer> side_list = new ArrayList<>();
        while (!main_list.isEmpty()) {
            int temp_page = main_list.remove(0);

            if (pages_and_paths[temp_page - 1][0] == 0) stop_counting = true;

            side_list.addAll(get_next_possible(pages_and_paths, marked, temp_page));

            if (main_list.isEmpty() && !side_list.isEmpty()) {
                main_list.addAll(side_list);
                side_list.clear();
                if (!stop_counting) count++;

            }
        }

        boolean reached_all = true;
        for (boolean bool: marked) {
            if (!bool) {
                reached_all = false;
                break;

            }
        }

        if (reached_all) System.out.println("Y");
        else System.out.println("N");

        System.out.println(count);
    }

    public static Set<Integer> get_next_possible(int[][] pages_and_paths, boolean[] marked, int current_page) {
        Set<Integer> output = new HashSet<>();
        int[] paths = pages_and_paths[current_page - 1];

        for (int i = 1; i < paths[0] + 1; i++) {
            if (marked[paths[i] - 1]) continue;
            marked[paths[i] - 1] = true;
            output.add(paths[i]);

        }

        return output;
    }
}
