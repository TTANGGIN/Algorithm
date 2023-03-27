package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {    // 구슬의 위치와 이동 횟수를 저장하는 클래스
    int rx, ry, bx, by, count;

    public Node(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;   // 빨간 구슬의 x좌표
        this.ry = ry;   // 빨간 구슬의 y좌표
        this.bx = bx;   // 파란 구슬의 x좌표
        this.by = by;   // 파란 구슬의 y좌표
        this.count = count; // 이동 횟수
    }
}

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;     // rx, ry, bx, by
    static int[] dx = {-1, 1, 0, 0};    // 상하좌우 x좌표
    static int[] dy = {0, 0, -1, 1};    // 상하좌우 y좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String row = st.nextToken();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    public static int bfs(int rx, int ry, int bx, int by) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.count > 10) break;

            if (board[current.rx][current.ry] == 'O' && board[current.bx][current.by] != 'O') {
                return 1;
            }

            for (int i = 0; i < 4; i++) {
                int[] nextRed = move(current.rx, current.ry, dx[i], dy[i]);
                int[] nextBlue = move(current.bx, current.by, dx[i], dy[i]);

                if (board[nextBlue[0]][nextBlue[1]] == 'O') continue;

                if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                    // 이동 후 빨간 구슬과 파란 구슬이 같은 위치에 있을 때
                    switch (i) {
                        case 0: // 상
                            if (current.rx > current.bx) nextRed[0]++;
                            else nextBlue[0]++;
                            break;
                        case 1: // 하
                            if (current.rx < current.bx) nextRed[0]--;
                            else nextBlue[0]--;
                            break;
                        case 2: // 좌
                            if (current.ry > current.by) nextRed[1]++;
                            else nextBlue[1]++;
                            break;
                        case 3: // 우
                            if (current.ry < current.by) nextRed[1]--;
                            else nextBlue[1]--;
                            break;
                    }
                }

                if (!visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
                    visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
                    queue.add(new Node(nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], current.count + 1));
                }
            }
        }

        return 0;
    }

    public static int[] move(int x, int y, int dx, int dy) {
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
        }
        return new int[]{x, y};
    }
}
