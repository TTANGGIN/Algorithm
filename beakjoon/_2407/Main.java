package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static BigInteger[][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        cache = new BigInteger[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                cache[i][j] = BigInteger.valueOf(-1);
            }
        }

        System.out.println(combination(n, m));
    }

    public static BigInteger combination(int n, int m) {
        if (n == m || m == 0)
            return BigInteger.ONE;

        if (!cache[n][m].equals(BigInteger.valueOf(-1))) {
            return cache[n][m];
        }

        cache[n][m] = combination(n - 1, m - 1).add(combination(n - 1, m));
        return cache[n][m];
    }
}
