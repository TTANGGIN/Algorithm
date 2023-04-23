package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int[] solution(String s) {
        Pattern pattern = Pattern.compile("[{](\\d.*?)[}]");
        Matcher matcher = pattern.matcher(s);

        Map<Integer, String[]> tupleMap = new HashMap<>();
        while (matcher.find()) {
            String[] arr = matcher.group(1).split(",");
            tupleMap.put(arr.length - 1, arr);

            if(matcher.group(1) == null)
                break;
        }

        int tupleSize = tupleMap.size();
        int[] answer = new int[tupleSize];
        Set<String> hashSet = new HashSet<>(tupleSize);

        for (int i = 0; i < tupleSize; i++) {
            for (String j : tupleMap.get(i)) {
                if (!hashSet.contains(j)) {
                    hashSet.add(j);
                    answer[i] = Integer.parseInt(j);
                    break;
                }
            }
        }

        return answer;
    }
}
