using System;

public class Solution
{
    int boardX;
    int boardY;
    public int[] solution(int m, int n, int startX, int startY, int[,] balls)
    {
        int ball_count = balls.GetLength(0);
        int[] answer = new int[ball_count];
        boardX = m;
        boardY = n;

        for (int i = 0; i < ball_count; i++)
        {
            int targetX = balls[i,0];
            int targetY = balls[i,1];

            answer[i] = calulateDistance(startX, startY, targetX, targetY);
        }

        return answer;
    }

    private int calulateDistance(int sourceX, int sourceY, int targetX, int targetY)
    {
        int result = int.MaxValue;
        for (int i = 0; i < 4; i++)
        {
            if (sourceX != targetX || targetY > sourceY)
                result = (int) Math.Min(result, Math.Pow(sourceX - targetX, 2) + Math.Pow(sourceY + targetY, 2));
            if (sourceY != targetY || targetX > sourceX)
                result = (int) Math.Min(result, Math.Pow(sourceX + targetX, 2) + Math.Pow(sourceY - targetY, 2));
            if (sourceX != targetX || targetY < sourceY)
                result = (int) Math.Min(result, Math.Pow(sourceX - targetX, 2) + Math.Pow(2 * boardY - targetY - sourceY, 2));
            if (sourceY != targetY || targetX < sourceX)
                result = (int) Math.Min(result, Math.Pow(2 * boardX - targetX - sourceX, 2) + Math.Pow(sourceY - targetY, 2));
        }

        return result;
    }
}