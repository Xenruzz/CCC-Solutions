//Alex
//CCC 2017 S4
//https://dmoj.ca/problem/ccc17s4
//11/15

import java.util.*;
import java.io.*;

public class Main {

    static class Pipe implements Comparable<Pipe>{
        int a, b, c, d;

        public Pipe(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;

        }

        @Override
        public int compareTo(Pipe o) {
            if (c != o.c) {
                return c - o.c;

            } else {
                return this.d - o.d;

            }
        }
    }

    static int n, m, d;
    static Pipe[] edges;
    static int[] parent;
    static int[] rank;

    public static void make_set(int v) {
        parent[v] = v;
        rank[v] = 1;

    }

    public static int find_set(int v) {
        if (parent[v] == v) return v;

        return parent[v] = find_set(parent[v]);

    }

    public static boolean union_sets(int a, int b) {
        a = find_set(a);
        b = find_set(b);

        if (a != b) {
            if (rank[a] < rank[b]) {
                int temp = a;
                a = b;
                b = temp;

            }

            parent[b] = a;
            rank[a] += rank[b];
            return true;

        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m =  Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        edges = new Pipe[m];

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) make_set(i);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Pipe(a, b, c, i);

        }

        Arrays.sort(edges);

        ArrayList<Pipe> mst = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < m; i++) {
            Pipe p = edges[i];

            if (union_sets(p.a, p.b)) {
                if (p.d > n - 2) count++;

                mst.add(p);

                edges[i] = null;

                if (mst.size() == n - 1) break;
            }
        }

        System.out.println(count);
    }
}
