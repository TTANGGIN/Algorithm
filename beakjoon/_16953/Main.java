package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
    public static int bfs() {
        if (a == b) {
            return 0;
        }

        Queue<Long> queue = new LinkedList<>();
        Queue<Integer> moves = new LinkedList<>();
        queue.add((long) a);
        moves.add(1);

        while (!queue.isEmpty()) {
            long curr = queue.poll();
            int count = moves.poll();

            long op1 = curr * 2;
            long op2 = curr * 10 + 1;

            if (op1 == b || op2 == b) {
                return count + 1;
            }

            if (op1 < b) {
                queue.add(op1);
                moves.add(count + 1);
            }

            if (op2 < b) {
                queue.add(op2);
                moves.add(count + 1);
            }
        }

        return -1;
    }
}