package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int count;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n];
        count = 0;

        caseOfQueensPos(0);

        System.out.println(count);
    }

    public static void caseOfQueensPos(int index) {
        if (index == n) {
            count++;
            return;
        }

        boolean isPossible;
        for (int i = 0; i < n; i++) {
            isPossible = true;
            for (int j = 0; j < index; j++) {
                if (board[j] == i || Math.abs(index-j) == Math.abs(i-board[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                board[index] = i;
                caseOfQueensPos(index+1);
            }
        }
    }
}