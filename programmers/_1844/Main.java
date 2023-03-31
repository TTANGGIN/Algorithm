package org.example;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int px, py;

    public Node(int px, int py) {
        this.px = px;   // 플레이어 x좌표
        this.py = py;   // 플레이어 y좌표
    }
}

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[][] dist;
    static int goalX;                       // 적진 x좌표
    static int goalY;                       // 적진 y좌표
    static int[] dx = {-1, 1, 0, 0};        // 상하좌우 x좌표
    static int[] dy = {0, 0, -1, 1};        // 상하좌우 y좌표

    public static int solution(int[][] maps) {
        goalX = maps.length;
        goalY = maps[0].length;
        map = maps;
        dist = new int[goalX][goalY];
        visited = new boolean[goalX+1][goalY+1];

        dist[0][0] = 1;

        return bfs(0, 0);
    }

    public static int bfs(int px, int py) {
        Queue<Node> q = new LinkedList<>();
        visited[px][py] = true;
        q.add(new Node(px, py));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur.px + dx[i];
                int newY = cur.py + dy[i];
                if (newX >= 0 && newX < goalX && newY >= 0 && newY < goalY
                        && !visited[newX][newY] && map[newX][newY] != 0) {
                    visited[newX][newY] = true;
                    dist[newX][newY] = dist[cur.px][cur.py] + 1;
                    q.add(new Node(newX, newY));
                }
            }
        }

        if (dist[goalX - 1][goalY - 1] == 0) {
            return -1;
        }
        return dist[goalX - 1][goalY - 1];
    }

    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        System.out.println(solution(maps));
    }
}