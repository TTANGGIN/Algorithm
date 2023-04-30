using System;

public class Solution
{
    private int[] answer;
    private int[] apeach_info;
    private int[] ryan_info;
    private int highest_diff = -1;

    public int[] solution(int n, int[] info)
    {
        answer = new int[11];
        apeach_info = info;
        ryan_info = new int[11];

        dfs(n, 0, 0, 0);

        return highest_diff != -1 ? answer : new int[] { -1 };
    }

    private void dfs(int left_arrows, int apeach_score, int ryan_score, int index)
    {
        if (index == 11)
        {
            ryan_info[10] = left_arrows;

            int diff = ryan_score - apeach_score;
            if (apeach_score < ryan_score && highest_diff <= diff)
            {
                if (highest_diff == diff && !isLowerArr(ryan_info)) return;
                highest_diff = diff;
                answer = (int[])ryan_info.Clone();
            }
            ryan_info[10] = 0;
            return;
        }
        

        int required_score = apeach_info[index] + 1;
        if (required_score <= left_arrows)
        {
            ryan_info[index] = required_score;
            dfs(left_arrows - required_score, apeach_score, ryan_score + (10 - index), index + 1);
            ryan_info[index] = 0;
        }

        if (apeach_info[index] != 0) 
            dfs(left_arrows, apeach_score + (10 - index), ryan_score, index + 1);
        else
            dfs(left_arrows, apeach_score, ryan_score, index + 1);
    }

    private bool isLowerArr(int[] new_arr)
    {
        for (int i = 9; i >= 0; i--)
        {
            if (answer[i] == new_arr[i]) continue;
            if (answer[i] < new_arr[i]) return true;
            break;
        }
        return false;
    }
}
