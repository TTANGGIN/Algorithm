using System;

public class Solution
{
    int n;
    bool[] visited;
    int[,] computers;
    public int solution(int n, int[,] computers)
    {
        this.n = n;
        this.computers = computers;
        visited = new bool[n];

        int answer = 0;

        for (int i = 0; i < n; i++)
        {
            if (visited[i]) continue;
            DFS(i);
            answer++;
        }
            
        return answer;
    }

    private void DFS(int index)
    {
        visited[index] = true;

        for (int i = 0; i < n; i++)
        {
            if (!visited[i] && computers[index, i] == 1)
            {
                DFS(i);
            }
        }
    }
}