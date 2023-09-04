using System;
using System.Collections.Generic;

public class Solution
{
    public int solution(int[] topping)
    {
        int answer = 0;

        HashSet<int> s1 = new HashSet<int>();
        HashSet<int> s2 = new HashSet<int>();

        for (int i = 1; i < topping.Length - 1; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (!s1.Contains(topping[j]))
                {
                    s1.Add(topping[j]);
                }
            }

            for (int k = i; k < topping.Length; k++)
            {
                if (!s2.Contains(topping[k]))
                {
                    s2.Add(topping[k]);
                }
            }

            if (s1.Count == s2.Count)
            {
                answer++;
            }

            s1.Clear();
            s2.Clear();
        }

        return answer;
    }

    //// pos : left = 0, right = 1
    //public int cutter(int pos, int[] left, int[] right)
    //{
    //    if ()
    //    return 0;
    //}
}