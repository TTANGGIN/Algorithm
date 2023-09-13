using System;
using System.Collections.Generic;

public class Solution
{
    public int solution(int n, int k, int[] enemy)
    {
        int answer = 0;
        int soldiers = n;
        int inv = k;
        MaxHeap heap = new MaxHeap();

        for (int i = 0; i < enemy.Length; i++)
        {
            heap.Insert(enemy[i]);

            if (soldiers < enemy[i])
            {
                if (inv == 0)
                {
                    break;
                }
                else
                {
                    soldiers += heap.ExtractMax();
                    inv--;
                }
            }

            soldiers -= enemy[i];
            answer++;
        }

        return answer;
    }

    class MaxHeap
    {
        private List<int> elements = new List<int>() { 0 };

        public void Insert(int element)
        {
            elements.Add(element);
            BubbleUp(elements.Count - 1);
        }

        public int ExtractMax()
        {
            if (elements.Count == 1) throw new InvalidOperationException("Heap is empty.");
            int maxValue = elements[1];
            elements[1] = elements[elements.Count - 1];
            elements.RemoveAt(elements.Count - 1);
            BubbleDown(1);
            return maxValue;
        }

        private void BubbleUp(int index)
        {
            while (index > 1 && elements[index / 2] < elements[index])
            {
                Swap(index, index / 2);
                index = index / 2;
            }
        }

        private void BubbleDown(int index)
        {
            int largest = index;

            while (true)
            {
                int left = 2 * index, right = 2 * index + 1;
                if (left < elements.Count && elements[left] > elements[largest])
                    largest = left;
                if (right < elements.Count && elements[right] > elements[largest])
                    largest = right;
                if (largest == index) break;
                Swap(index, largest);
                index = largest;
            }
        }

        private void Swap(int i, int j)
        {
            int temp = elements[i];
            elements[i] = elements[j];
            elements[j] = temp;
        }
    }
}