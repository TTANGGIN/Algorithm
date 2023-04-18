package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num = Integer.parseInt(st.nextToken());
        long pow = Integer.parseInt(st.nextToken());
        long div = Integer.parseInt(st.nextToken());

        System.out.println(getMod(num, pow, div));
    }

    public static long getMod(long num, long pow, long div) {
        if (pow == 1) {
            return num % div;
        }

        long half = getMod(num, pow / 2, div);
        long result = Math.floorMod(half * half, div);

        if (pow % 2 == 1) {
            result = Math.floorMod(result * num, div);
        }

        return result;
    }
}