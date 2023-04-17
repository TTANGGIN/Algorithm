package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
    int vertex;
    int weight;

    Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Main {
    static List<Pair>[] graph;
    static boolean[] visited;
    static int V;
    static int maxDistance = 0;
    static int maxNode = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            while (true) {
                int u = Integer.parseInt(st.nextToken());
                if (u == -1) break;
                int l = Integer.parseInt(st.nextToken());
                graph[v].add(new Pair(u, l));
            }
        }

        dfs(1, 0);
        visited = new boolean[V + 1];
        dfs(maxNode, 0);
        System.out.println(maxDistance);
    }

    public static void dfs(int index, int distance) {
        visited[index] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            maxNode = index;
        }

        for (Pair next : graph[index]) {
            int nextVertex = next.vertex;
            int nextWeight = next.weight;
            if (!visited[nextVertex]) {
                dfs(nextVertex, distance + nextWeight);
            }
        }
    }
}
