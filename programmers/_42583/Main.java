package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
    }


    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();  // bridge queue
        int time = 0;       // elapsed time
        int curWeight = 0;  // current weight
        int idx = 0;        // truck index

        while (idx < truck_weights.length) {
            if (q.size() == bridge_length) {
                curWeight -= q.poll();
            }

            if (curWeight + truck_weights[idx] <= weight) {
                q.add(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++;
            } else {
                q.add(0);
            }
            time++;
        }

        return time + bridge_length;
    }
}

