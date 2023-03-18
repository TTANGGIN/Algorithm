package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int BIG_BAG = 5;
    public static final int SMALL_BAG = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sugarWeight = Integer.parseInt(st.nextToken());
        int bagCount = containSugarToBag(sugarWeight);

        System.out.format("%d", bagCount);
    }

    static int containSugarToBag(int weight) {
        int bigBags = weight / BIG_BAG;
        int leftWeight = weight % BIG_BAG;
        int smallBags = 0;

        for (int i = bigBags; i >= 0; i--) {
            if ((leftWeight % SMALL_BAG != 0) && (bigBags != 0)) {
                bigBags--;
                leftWeight += BIG_BAG;
            } else if ((leftWeight % SMALL_BAG != 0) && (bigBags == 0)) {
                leftWeight += BIG_BAG;
            } else {
                smallBags = leftWeight / SMALL_BAG;
                break;
            }
        }

        if (bigBags == 0 && smallBags == 0) {
            return -1;
        }

        return bigBags + smallBags;
    }
}