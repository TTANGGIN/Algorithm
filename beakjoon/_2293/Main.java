package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int totalVal = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coin);

        int[] dp = new int[totalVal+1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= totalVal; j++) {
                dp[j] += dp[j-coin[i]];
            }
        }

        System.out.println(dp[totalVal]);
    }
}
