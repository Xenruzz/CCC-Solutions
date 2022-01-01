package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static int[] time_memo = new int[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

        HashMap<Integer, Set<Integer>> walkways = new HashMap<>();
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Set<Integer> temp_paths = walkways.getOrDefault(a, new HashSet<>());
            temp_paths.add(b);
            walkways.put(a, temp_paths);

        }

        int[] order = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            swap(x, y, order);

            Arrays.fill(time_memo, Integer.MAX_VALUE);

            time_memo[1] = 0;

            recurse_fill_array(1, n, 0, order, walkways);

            System.out.println(time_memo[n]);
        }
    }

    public static void swap(int x, int y, int[] order) {
        x--; y--;
        int temp = order[x];
        order[x] = order[y];
        order[y] = temp;

    }

    public static void recurse_fill_array(int station, int n, int time, int[] order, HashMap<Integer, Set<Integer>> walkways) {
        int best = time_memo[station] + 1;

        if (time < n - 1 && station == order[time]) {
            int next_station = order[time + 1];
            time_memo[next_station] = time;
            recurse_fill_array(next_station, n, time + 1, order, walkways);

        }

        Set<Integer> next_paths = walkways.getOrDefault(station, null);

        if (next_paths != null) {
            for (int next_station: next_paths) {
                if (time_memo[next_station] > best) {
                    time_memo[next_station] = best;
                    recurse_fill_array(next_station, n, time + 1, order, walkways);

                }
            }
        }
    }
}
