package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    List<Integer> answerList = new ArrayList<>();
    Map indexMap;
    String[] msgArr;
    int newIdxNum = 27;
    int msgLen;
    public int[] solution(String msg) {

        indexMap = new HashMap();
        msgLen = msg.length();
        msgArr = msg.split("");

        for (int i = 0; i < 26; i++) {
            char alphabet = (char) (i + 65);
            String alphabetStr = Character.toString(alphabet);
            int alphabetPos = i + 1;
            indexMap.put(alphabetStr, alphabetPos);
        }

        dfs(msgArr[0], 1);

        int[] answer = answerList.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }

    public void dfs(String w, int arrIdx) {
        if (arrIdx == msgLen) {
            answerList.add((Integer) indexMap.get(w));
            return;
        }

        String c = msgArr[arrIdx];
        String wc = w + c;

        if (!indexMap.containsKey(wc)) {
            indexMap.put(wc, newIdxNum++);
            answerList.add((Integer) indexMap.get(w));
            dfs(c, arrIdx + 1);
        } else {
            dfs(wc, arrIdx + 1);
        }
    }
}
