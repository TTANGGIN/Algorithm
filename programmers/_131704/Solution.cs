using System;
using System.Collections.Generic;

public class Solution
{
    public int solution(int[] order)
    {
        int answer = 0;
        int peek = 0;
        Stack<int> subBelt = new Stack<int>();

        for (int i = 1; i <= order.Length; i++)
        {
            bool isLoaded = false;

            if (order[answer] == i)
            {
                answer++;
                isLoaded = true;
            }
            while (subBelt.TryPeek(out peek) && peek == order[answer])
            {
                subBelt.Pop();
                answer++;
                isLoaded = true;
            }

            if (!isLoaded)
            {
                subBelt.Push(i);
            }

        }

        while (subBelt.TryPeek(out peek) && peek == order[answer])
        {
            subBelt.Pop();
            answer++;
        }

        return answer;
    }
}