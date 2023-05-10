using System;
using System.Linq;

public class Solution
{
    int answer;
    int contents;
    string target;
    string[] words;

    public int solution(string begin, string target, string[] words)
    {
        if (!words.Contains(target)) return 0;

        answer = int.MaxValue;
        contents = words.Length;
        bool[] visited = new bool[words.Length];
        this.words = words;
        this.target = target;

        DFS(begin, 0, 0, visited);


        return answer == int.MaxValue ? 0 : answer;
    }

    public void DFS(string source, int index, int serial, bool[] visited)
    {
        if (source == target)
        {
            answer = Math.Min(serial, answer);
            return;
        }
        if (serial >= contents) return;

        for (int i = 0; i < words.Length; i++)
        {
            if (visited[i]) continue;
            if (getEqualCharCount(source, words[i]) == source.Length - 1)
            {
                visited[i] = true;
                DFS(words[i], i, serial + 1, (bool[])visited.Clone());
            }
        }
    }

    public int getEqualCharCount(string source, string word)
    {
        int result = 0;

        for (int i = 0; i < source.Length; i++)
        {
            if (source.Substring(i, 1).CompareTo(word.Substring(i, 1)) == 0)
                result++;
        }

        return result;
    }
}