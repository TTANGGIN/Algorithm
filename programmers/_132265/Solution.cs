using System;
using System.Collections.Generic;

public class Solution
{
    public int solution(int[] topping)
    {
        int answer = 0;

        Dictionary<int, int> freqMap = new Dictionary<int, int>(topping.Length);

        foreach (int item in topping)
        {
            if (freqMap.ContainsKey(item))
            {
                freqMap[item]++;
            }
            else
            {
                freqMap[item] = 1;
            }
        }

        HashSet<int> left = new HashSet<int>();
        int right = freqMap.Count;

        for (int i = 0; i < topping.Length - 1; i++)
        {
            if (!left.Contains(topping[i]))
            {
                left.Add(topping[i]);
            }

            if (freqMap[topping[i]] == 1)
            {
                freqMap.Remove(topping[i]);
                right--;
            }
            else
            {
                --freqMap[topping[i]];
            }

            if (left.Count == right)
            {
                answer++;
            }
        }

        return answer;
    }

}