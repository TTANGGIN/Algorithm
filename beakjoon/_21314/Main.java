package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static int[] mkn2decMAX;
    static int[] mkn2decMin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        MKNumerals(input);

        System.out.format("%s\n%s", Arrays.toString(mkn2decMAX).replaceAll("[^0-9]","")
                , Arrays.toString(mkn2decMin).replaceAll("[^0-9]",""));
    }

    public static void MKNumerals(String input) {
        int sLen = input.length();
        int mCount = 0;
        char[] mkn = input.toCharArray();
        mkn2decMAX = new int[sLen];
        mkn2decMin = new int[sLen];

        for (int i = 0; i < sLen; i++) {
            if (mkn[i] == 'K') {
                mkn2decMin[i] = 5;

                if (mCount == 0) mkn2decMAX[i] = 5;
                else {
                    mkn2decMin[i-mCount] = 1;
                    mkn2decMAX[i-mCount] = 5;
                    mkn2decMAX[i] = 0;
                    mCount = 0;
                }
            } else {
                mkn2decMin[i] = 0;
                mkn2decMAX[i] = 0;
                mCount++;
            }
        }

        if (mCount != 0) {
            mkn2decMin[sLen-mCount] = 1;
            mkn2decMAX[sLen-mCount] = 1;
            for (int i = sLen - mCount + 1; i < sLen; i++) {
                mkn2decMAX[i] = 1;
            }
        }
    }

}