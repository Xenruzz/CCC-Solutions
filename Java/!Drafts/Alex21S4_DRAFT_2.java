//Alex
//2021 S4
//https://cemc.uwaterloo.ca/contests/computing/2021/ccc/seniorEF.pdf
//Incomplete - Draft - To Be Reviewed

package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

        HashMap<Integer, ArrayList<Integer>> walkways = new HashMap<>();

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> next = walkways.getOrDefault(a, new ArrayList<>());

            if (next.contains(b)) continue;
            next.add(b);

            walkways.put(a, next);
        }

        int[] trains = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> train_index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            train_index.put(trains[i], i);

        }

        String[] output = new String[d];
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

            swap_pos(x, y, trains, train_index);

            output[i] = recurse(1, 0, n, w, trains, walkways, train_index) + "";
        }

        for (int i = 0; i < d; i++) {
            System.out.println(output[i]);

        }
    }

    public static void swap_pos(int x, int y, int[] trains, HashMap<Integer, Integer> train_index) {
        x--;
        y--;
        int temp = trains[x];
        trains[x] = trains[y];
        trains[y] = trains[x];

        temp = train_index.get(x);
        train_index.put(x, train_index.get(y));
        train_index.put(y, temp);
    }

    public static int recurse(int current_station, int time, int n, int w, int[] trains, HashMap<Integer, ArrayList<Integer>> walkways, HashMap<Integer, Integer> train_index) {
        if (current_station == n) return time;
        if (memo.containsKey(current_station)) return memo.get(current_station);

        int best_time = Integer.MAX_VALUE;

        Set<Integer> next = next_possible(current_station, time, trains, walkways, train_index);

        for (int temp_station: next) {
            int temp_count = recurse(temp_station, n, w,time + 1, trains, walkways, train_index);
            best_time = Math.max(temp_count, best_time);

        }

        return best_time;
    }

    public static Set<Integer> next_possible(int current_station, int time, int[] trains, HashMap<Integer, ArrayList<Integer>> walkways, HashMap<Integer, Integer> train_index) {
        Set next = new HashSet(walkways.getOrDefault(current_station, new ArrayList<>()));

        int train_pos = train_index.get(current_station);

        if (time == train_pos) next.add(trains[time + 1]);

        if (train_pos < time) next.add(current_station);

        return next;
    }
}
