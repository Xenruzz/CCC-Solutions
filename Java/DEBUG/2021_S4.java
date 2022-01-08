//1-index everything
package com.company;

import java.util.*;
import java.io.*;

public class Main {

    static int n, w, d;
    static int[] w_dist;
    static HashMap<Integer, ArrayList<Integer>> walkways = new HashMap<>();
    static int[] train_order;
    static class Path implements Comparable<Path> {
        int station_num, dist;

        public Path(int station_num, int dist) {
            this.station_num = station_num;
            this.dist = dist;

        }

        @Override
        public int compareTo(Path o) {
            return dist - o.dist;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj.getClass() != this.getClass()) return false;

            Path p = (Path) obj;
            return p.dist == dist && p.station_num == station_num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            //we make sure to put it so you from "to" to "from" since we are working backwards
            //to find the distance from station N --> station i
            ArrayList<Integer> temp_next = walkways.getOrDefault(to, new ArrayList<>());
            temp_next.add(from);
            walkways.put(to, temp_next);

        }

        dijkstra_w_dist();

        train_order = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            train_order[i] = Integer.parseInt(st.nextToken());

        }

        PriorityQueue<Integer> acting_set = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            int subway_dist = i - 1;
            int walk_dist = w_dist[train_order[i]];


            int total_dist = subway_dist + walk_dist;
            if (walk_dist == Integer.MAX_VALUE) total_dist = Integer.MAX_VALUE;

            acting_set.add(total_dist);

        }

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            swap_and_update_tset(acting_set, x, y);

            System.out.println(acting_set.peek());

        }
    }

    public static void swap_and_update_tset(PriorityQueue<Integer> acting_set, int x, int y) {
        //remove old values from the prio queue
        int x_old_dist = x - 1 + w_dist[train_order[x]];
        int y_old_dist = y - 1 + w_dist[train_order[y]];

        if (x_old_dist < 0) x_old_dist = Integer.MAX_VALUE;
        if (y_old_dist < 0) y_old_dist = Integer.MAX_VALUE;

        acting_set.remove(x_old_dist);
        acting_set.remove(y_old_dist);

        //swap the actual train_order
        int temp = train_order[x];
        train_order[x] = train_order[y];
        train_order[y] = temp;

        //add new values to prio queue
        int x_new_dist = x - 1 + w_dist[train_order[x]];
        int y_new_dist = y - 1 + w_dist[train_order[y]];

        if (x_new_dist < 0) x_new_dist = Integer.MAX_VALUE;
        if (y_new_dist < 0) y_new_dist = Integer.MAX_VALUE;

        acting_set.add(x_new_dist);
        acting_set.add(y_new_dist);

    }

    public static void dijkstra_w_dist() {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Path> queue = new PriorityQueue<>();
        w_dist = new int[n + 1];

        for (int i = 1; i < n; i++) { //default the values in queue and w_dist
            queue.add(new Path(i, Integer.MAX_VALUE));
            w_dist[i] = Integer.MAX_VALUE;

        }

        queue.add(new Path(4, 0));
        w_dist[n] = 0;

        while (!queue.isEmpty()) {
            Path current_path = queue.poll();
            int station_num = current_path.station_num;
            int dist = current_path.dist;

            if (dist == Integer.MAX_VALUE) break;

            dist++;

            visited[station_num] = true;

            ArrayList<Integer> next_possible = walkways.getOrDefault(station_num, new ArrayList<>());

            for (int next_station : next_possible) {
                if (visited[next_station]) continue;

                if (dist < w_dist[next_station]) {
                    //remove old station
                    queue.remove(new Path(next_station, w_dist[next_station]));
                    //re insert with new dist
                    queue.add(new Path(next_station, dist));

                    //update w_dist
                    w_dist[next_station] = dist;

                }
            }
        }
    }
}
