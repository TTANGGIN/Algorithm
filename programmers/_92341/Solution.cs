using System;
using System.Collections.Generic;
using System.Linq;

public class ParkingRecord
{
    public string car_num;
    public int fee;
    
    public ParkingRecord(string car_num, int fee)
    {
        this.car_num = car_num;
        this.fee = fee;
    }
}

public class Solution
{
    int base_time;
    int base_rate;
    int unit_time;
    int unit_rate;
    public int[] solution(int[] fees, string[] records)
    {
        base_time = fees[0];
        base_rate = fees[1];
        unit_time = fees[2];
        unit_rate = fees[3];

        Dictionary<string, Queue<string>> parking_dict = new Dictionary<string, Queue<string>>();

        for (int i = 0; i < records.Length; i++)
        {
            string[] record = records[i].Split(' ');
            string time = record[0].Replace(":", "");
            string car_num = record[1];

            if (!parking_dict.ContainsKey(car_num))
            {
                Queue<string> queue = new Queue<string>();
                queue.Enqueue(time);
                parking_dict.Add(car_num, queue);
            }
            else
            {
                parking_dict[car_num].Enqueue(time);
            }
        }

        List<ParkingRecord> parking_records = new List<ParkingRecord>();
        foreach (KeyValuePair<string, Queue<string>> i in parking_dict)
        {
            parking_records.Add(new ParkingRecord(i.Key, calculateTotalFee(i.Value)));
        }
        List<ParkingRecord> sortedList = parking_records.OrderBy(p => p.car_num).ToList();
        
        int[] answer = sortedList.ConvertAll(e => e.fee).ToArray();
        

        return answer;
    }

    private int calculateTotalElapsedTime(string start)
    {
        return calculateTotalElapsedTime(start, "2359");
    }

    private int calculateTotalElapsedTime(string start, string end)
    {
        int hour = int.Parse(end.Substring(0, 2)) - int.Parse(start.Substring(0,2));
        int minute = int.Parse(end.Substring(2, 2)) - int.Parse(start.Substring(2, 2));

        return (hour * 60) + minute;
    }

    private int calculateTotalFee(Queue<string> queue)
    {
        int time = 0;

        while (queue.Count > 0)
        {
            string start;
            string end;
            if (queue.Count > 1)
            {
                start = queue.Dequeue();
                end = queue.Dequeue();
                time += calculateTotalElapsedTime(start, end);
            }
            else
            {
                time += calculateTotalElapsedTime(queue.Dequeue());
            }
        }

        if (base_time >= time) return base_rate;

        return base_rate + ((int) Math.Ceiling((double) (time - base_time) / unit_time)) * unit_rate;
    }
}