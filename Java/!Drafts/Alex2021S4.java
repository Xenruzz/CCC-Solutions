//Alex
//2021 S4
//https://cemc.uwaterloo.ca/contests/computing/2021/ccc/seniorEF.pdf
//To Be Revised (Incomplete - Draft)

package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = split[0];
        int w = split[1];
        int d = split[2];

        HashMap<Integer, ArrayList<Integer>> walkways = new HashMap<>();

        for (int i = 0; i < w; i++) {
            split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> temp = walkways.getOrDefault(split[0], new ArrayList<>());
            temp.add(split[1]);

            walkways.put(split[0], temp);

        }

        int[] stations = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] output_times = new int[n];

        for (int i = 0; i < d; i++) {
            split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x = split[0], y = split[1];

            int temp = stations[x];
            stations[x] = stations[y];
            stations[y] = temp;

            output_times[i] = search(stations, walkways, n);

        }

        for (int i = 0; i < n; i++) {
            System.out.println(output_times[i]);

        }
    }

    public static int search(int[] stations, HashMap<Integer, ArrayList<Integer>> walkways, int n) {
        Set<Integer> marked = new HashSet<>();
        int time = 0;
        ArrayList<Integer> main_list = new ArrayList<>(next_possible(stations, walkways, time++, stations[0], n));

        Set<Integer> side_set = new HashSet<>();

        while (main_list.isEmpty()) {
            int temp_station = main_list.remove(0);

            if (marked.contains(temp_station)) continue;
            if (temp_station == n) return time;

            marked.add(temp_station);

            side_set.addAll(next_possible(stations, walkways, time, temp_station, n));

            if (main_list.isEmpty() && !side_set.isEmpty()) {
                main_list.addAll(side_set);
                time++;

            }
        }

        return time;
    }

    public static Set<Integer> next_possible(int[] stations, HashMap<Integer, ArrayList<Integer>> walkways, int time, int current_station, int n) {
        Set<Integer> set = new HashSet<>();

        if (stations[time] == current_station) {
            if (time < n - 1) set.add(stations[time + 1]);

        }

        for (int key: walkways.keySet()) {
            if (key == current_station) set.addAll(walkways.get(key));

        }

        return set;
    }
}
