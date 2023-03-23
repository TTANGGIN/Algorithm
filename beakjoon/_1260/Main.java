package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean edge[][];
    static boolean visitedOfDFS[];
    static boolean visitedOfBFS[];
    static int n;
    static int m;
    static int v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        edge = new boolean[n + 1][n + 1];
        visitedOfDFS = new boolean[n + 1];
        visitedOfBFS = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edge[u][v] = true;
            if (!edge[v][u]) edge[v][u] = true; // 방향성이 있는 그래프라면 이 줄은 필요 없음.
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    public static void dfs(int cur) {
        visitedOfDFS[cur] = true;
        System.out.format("%d ", cur);

        for (int i = 1; i <= n; i++) {
            if (visitedOfDFS[i] || !edge[cur][i])
                continue;
            dfs(i);
        }
    }

    public static void bfs(int cur) {
        Queue<Integer> queue = new LinkedList<>();
        visitedOfBFS[cur] = true;
        queue.add(cur);

        while (!queue.isEmpty()) {
            int here = queue.poll();
            System.out.format("%d ", here);
            for (int i = 1; i <= n; i++) {
                if (visitedOfBFS[i] || !edge[here][i])
                    continue;
                visitedOfBFS[i] = true;
                queue.add(i);
            }
        }

    }

}