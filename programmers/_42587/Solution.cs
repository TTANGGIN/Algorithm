using System;
using System.Collections.Generic;
using System.Linq;

public class Solution
{
    public int solution(int[] priorities, int location)
    {
        int answer = 0;
        Queue<(int priority, int index)> queue = new Queue<(int priority, int index)>();

        for (int i = 0; i < priorities.Length; i++)
        {
            queue.Enqueue((priorities[i], i));
        }

        while (queue.Count > 0)
        {
            var current = queue.Dequeue();
            if (queue.Count > 0 && current.priority < queue.Max(item => item.priority))
            {
                queue.Enqueue(current);
            }
            else
            {
                answer++;
                if (current.index == location)
                {
                    break;
                }
            }
        }
        return answer;
    }
}