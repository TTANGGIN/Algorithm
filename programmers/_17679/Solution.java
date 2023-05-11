package org.example;

import java.util.*;

public class Solution {
    String[][] gBoard;
    public int solution(int m, int n, String[] board) {

        gBoard = new String[m][n];
        setBoard(m, n, board);

        boolean isEnd;
        do {
            isEnd = find4Block(m, n);
            applyGravity(m, n);
        } while (isEnd);

        int answer = getNullCount(m, n);
        return answer;
    }

    private boolean find4Block(int m , int n) {
        boolean hasBlock = false;

        List<Queue> blockList = new ArrayList<>();
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                blockList.add(scan4Block(i, j));
            }
        }
        for (Queue<int[]> q : blockList) {
            for (int[] c : q) {
                hasBlock = true;
                gBoard[c[0]][c[1]] = null;
            }
        }

        return hasBlock;
    }

    private Queue<int[]> scan4Block(int y, int x) {
        String here = gBoard[y][x];
        Queue<int[]> queue = new LinkedList<>();

        if (here == null) return queue;

        // 좌상
        if (here.equals(gBoard[y][x-1]) && here.equals(gBoard[y-1][x-1]) && here.equals(gBoard[y-1][x])) {
            queue.add(new int[]{y, x});
            queue.add(new int[]{y, x-1});
            queue.add(new int[]{y-1, x-1});
            queue.add(new int[]{y-1, x});
        }
        // 우상
        if (here.equals(gBoard[y][x+1]) && here.equals(gBoard[y-1][x+1]) && here.equals(gBoard[y-1][x])) {
            queue.add(new int[]{y, x});
            queue.add(new int[]{y, x+1});
            queue.add(new int[]{y-1, x+1});
            queue.add(new int[]{y-1, x});
        }
        // 우하
        if (here.equals(gBoard[y][x+1]) && here.equals(gBoard[y+1][x+1]) && here.equals(gBoard[y+1][x])) {
            queue.add(new int[]{y, x});
            queue.add(new int[]{y, x+1});
            queue.add(new int[]{y+1, x+1});
            queue.add(new int[]{y+1, x});
        }
        // 좌하
        if (here.equals(gBoard[y][x-1]) && here.equals(gBoard[y+1][x-1]) && here.equals(gBoard[y+1][x])) {
            queue.add(new int[]{y, x});
            queue.add(new int[]{y, x-1});
            queue.add(new int[]{y+1, x-1});
            queue.add(new int[]{y+1, x});
        }

        return queue;
    }

    private void applyGravity(int m, int n) {
        Queue<String> queue = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (gBoard[j][i] != null) {
                    queue.add(gBoard[j][i]);
                }
            }
            for (int j = m - 1; j >= 0; j--) {
                gBoard[j][i] = queue.poll();
            }
        }
    }

    private void setBoard(int m, int n, String[] board) {
        for (int i = 0; i < m; i++) {
            String[] block = board[i].split("");
            for (int j = 0; j < n; j++) {
                gBoard[i][j] = block[j];
            }
        }
    }

    private int getNullCount(int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gBoard[i][j] == null) count++;
            }
        }

        return count;
    }
}
