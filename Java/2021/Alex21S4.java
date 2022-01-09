//Alex
//2021 S4
//https://cemc.uwaterloo.ca/contests/computing/2021/ccc/seniorEF.pdf
//15/15

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

        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            int subway_dist = i - 1;
            int walk_dist = w_dist[train_order[i]];


            int total_dist = subway_dist + walk_dist;
            if (walk_dist == Integer.MAX_VALUE) total_dist = Integer.MAX_VALUE;

            tmap.put(total_dist, tmap.getOrDefault(total_dist, 0) + 1);

        }

        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            swap_and_update_tset(tmap, x, y);

            System.out.println(tmap.firstKey());

        }
    }

    public static void swap_and_update_tset(TreeMap<Integer, Integer> tmap, int x, int y) {
        //remove old values from the tmap
        int x_old_dist = x - 1 + w_dist[train_order[x]];
        int y_old_dist = y - 1 + w_dist[train_order[y]];

        if (x_old_dist < 0) x_old_dist = Integer.MAX_VALUE;
        if (y_old_dist < 0) y_old_dist = Integer.MAX_VALUE;

        int x_count = tmap.get(x_old_dist);
        int y_count = tmap.get(y_old_dist);

        if (x_count > 1) tmap.put(x_old_dist, x_count - 1);
        else tmap.remove(x_old_dist);

        if (y_count > 1) tmap.put(y_old_dist, y_count - 1);
        else tmap.remove(y_old_dist);

        //swap the actual train_order
        int temp = train_order[x];
        train_order[x] = train_order[y];
        train_order[y] = temp;

        //add new values to tmap
        int x_new_dist = x - 1 + w_dist[train_order[x]];
        int y_new_dist = y - 1 + w_dist[train_order[y]];

        if (x_new_dist < 0) x_new_dist = Integer.MAX_VALUE;
        if (y_new_dist < 0) y_new_dist = Integer.MAX_VALUE;

        tmap.put(x_new_dist, tmap.getOrDefault(x_new_dist, 0) + 1);
        tmap.put(y_new_dist, tmap.getOrDefault(y_new_dist, 0) + 1);

    }

    public static void dijkstra_w_dist() {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Path> queue = new PriorityQueue<>();
        w_dist = new int[n + 1];

        Arrays.fill(w_dist, Integer.MAX_VALUE);

        queue.add(new Path(n, 0));
        w_dist[n] = 0;

        while (!queue.isEmpty()) {
            Path current_path = queue.poll();
            int station_num = current_path.station_num;
            int dist = current_path.dist;

            if (dist == Integer.MAX_VALUE) break;
            if (visited[station_num]) continue;

            dist++;
            visited[station_num] = true;

            ArrayList<Integer> next_possible = walkways.getOrDefault(station_num, new ArrayList<>());

            for (int next_station : next_possible) {
                if (visited[next_station]) continue;

                if (dist < w_dist[next_station]) {
                    //update w_dist
                    w_dist[next_station] = dist;

                    queue.add(new Path(next_station, dist));
                }
            }
        }
    }
}
