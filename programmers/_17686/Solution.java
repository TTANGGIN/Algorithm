package org.example;

import java.util.Arrays;

class IndexedString {
    String head;
    int number;
    int index;

    public IndexedString(String head, int number, int index) {
        this.head = head;
        this.number = number;
        this.index = index;
    }
}
class Solution {
    int fLen;
    IndexedString[] idxStrArr;
    public String[] solution(String[] files) {
        fLen = files.length;
        String[] answer = new String[fLen];
        idxStrArr = new IndexedString[fLen];

        for (int i = 0; i < fLen; i++) {
            String fileHead = "";
            int fileNumber = 0;

            int isTail = 0;
            for (int j = 0; j < files[i].length(); j++) {
                String s = files[i].substring(j, j+1);
                if (s.matches("\\d")) {
                    if (isTail == 0) isTail++;
                    fileNumber = (fileNumber * 10) + Integer.parseInt(s);
                } else if (isTail == 0) {
                    fileHead += s.toLowerCase();
                } else if (isTail == 1) {
                    break;
                }
            }

            idxStrArr[i] = new IndexedString(fileHead, fileNumber, i);
        }

        for (int i = 0; i < fLen; i++) {
            answer[i] = files[getSortedOrder()[i]];
        }

        return answer;
    }

    public int[] getSortedOrder() {
        Arrays.sort(idxStrArr, (a, b) -> {
            String aHead = a.head;
            String bHead = b.head;

            int aNumber = a.number;
            int bNumber = b.number;

            if (aHead.equals(bHead)) {
                return Integer.compare(aNumber, bNumber);
            }

            return aHead.compareTo(bHead);
        });

        int[] result = new int[fLen];
        for (int i = 0; i < idxStrArr.length; i++) {
            result[i] = idxStrArr[i].index;
        }
        return result;
    }

}

