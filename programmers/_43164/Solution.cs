using System;

public class Solution
{
    int ticket_num;
    int point;
    string[,] tickets;
    string[] answer;
    public string[] solution(string[,] tickets)
    {
        ticket_num = tickets.GetLength(0);
        point = ticket_num + 1;
        this.tickets = tickets;
        answer = new string[point];

        string[] route = new string[point];
        route[0] = "ICN";

        for (int i = 0; i < ticket_num; i++)
        {
            if (tickets[i, 0].Equals("ICN"))
            {
                route[1] = tickets[i, 1];
                dfs(i, 1, new bool[ticket_num], (string[])route.Clone());
            }
        }

        
        return answer;
    }

    public void dfs(int index, int serial, bool[] visited, string[] route)
    {
        if (serial >= ticket_num)
        {
            compareToVisit(route);
            return;
        }

        visited[index] = true;
        string arrival = tickets[index, 1];

        for (int i = 0; i < ticket_num; i++)
        {
            if (visited[i]) continue;

            if (arrival.Equals(tickets[i,0]))
            {
                route[serial + 1] = tickets[i, 1];
                dfs(i, serial + 1, (bool[])visited.Clone(), (string[])route.Clone());
            }
        }
    }

    public void compareToVisit(string[] route)
    {
        for (int i = 0; i < route.Length; i++)
        {
            int comp = route[i].CompareTo(answer[i]);
            if (comp < 0 || answer[i] == null)
            {
                answer = (string[])route.Clone();
                return;
            }
            else if (comp > 0) return;
        }
    }
}