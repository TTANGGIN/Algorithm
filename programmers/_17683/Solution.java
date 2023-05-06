package org.example;

import java.util.Arrays;

class MusicInfo {
    public String start;
    public String end;
    public String name;
    public String melody;

    public MusicInfo(String start, String end, String name, String melody) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.melody = melody;
    }
}
class Solution {

    public String solution(String m, String[] musicinfos) {

        String answer = "(None)";
        int maxTime = 0;
        m = replaceSharpToLowerCase(m);

        for (String i : musicinfos) {
            String[] info = i.split(",");
            MusicInfo musicInfo = new MusicInfo(info[0], info[1], info[2], info[3]);

            int playTime = getPlayTime(musicInfo.start, musicInfo.end);
            String convertMelody = replaceSharpToLowerCase(musicInfo.melody);

            StringBuilder sb = new StringBuilder();;
            int div = playTime/convertMelody.length();
            int mod = playTime%convertMelody.length();
            for(int j = 0 ; j < div; j ++)
                sb.append(convertMelody);
            for(int j = 0 ; j < mod; j++)
                sb.append(convertMelody.charAt(j));

            if(sb.toString().contains(m)) {
                if (playTime > maxTime) {
                    answer = musicInfo.name;
                    maxTime = playTime;
                }
            }
        }

        return answer;
    }

    private int getPlayTime(String start, String end) {
        int hour = Integer.parseInt(end.substring(0, 2)) - Integer.parseInt(start.substring(0, 2));
        int minute = Integer.parseInt(end.substring(3, 5)) - Integer.parseInt(start.substring(3, 5));

        return (hour * 60) + minute;
    }

    public String replaceSharpToLowerCase(String s) {

        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - 2; i >= 0 ; i--) {
            if(sb.charAt(i + 1) != '#') continue;

            sb.deleteCharAt(i + 1);
            sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
        }

        return sb.toString();
    }
}