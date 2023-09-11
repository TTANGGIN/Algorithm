using System;

public class Solution
{
    public int[] solution(int brown, int yellow)
    {
        int[] answer = new int[2];
        int sqrtY = (int)Math.Sqrt(yellow);

        for (int i = 1; i <= sqrtY; i++)
        {
            if (yellow % i == 0)
            {
                int b = yellow / i;
                int perimeters = 2 * (i + b) + 4;
                if (brown == perimeters)
                {
                    answer[0] = Math.Max(i, b) + 2;
                    answer[1] = Math.Min(i, b) + 2;
                    break;
                }
            }
        }

        return answer;
    }
}