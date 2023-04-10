package org.example;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String numbers) {
        Set<Integer> sequenceSet = new HashSet<>();
        generatePermutations("", numbers, sequenceSet);

        int primeCount = 0;
        for (int number : sequenceSet) {
            if (isPrime(number)) {
                primeCount++;
            }
        }
        return primeCount;
    }

    public static void generatePermutations(String prefix, String numbers, Set<Integer> sequenceSet) {
        int n = numbers.length();
        if (!prefix.isEmpty()) {
            sequenceSet.add(Integer.parseInt(prefix));
        }

        for (int i = 0; i < n; i++) {
            if (!prefix.isEmpty() || numbers.charAt(i) != '0') {
                generatePermutations(prefix + numbers.charAt(i),
                        numbers.substring(0, i) + numbers.substring(i + 1, n), sequenceSet);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
