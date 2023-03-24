#include <string>
#include <vector>
#include<iostream>

using namespace std;

int dfs(vector<int>& numbers, int target, int sum, int index)
{
	if (index == numbers.size())
	{
		return (sum == target) ? 1 : 0;
	}

	int count = 0;
	count += dfs(numbers, target, sum + numbers[index], index + 1);
	count += dfs(numbers, target, sum - numbers[index], index + 1);

	return count;
}

int solution(vector<int> numbers, int target)
{
	return dfs(numbers, target, 0, 0);
}

/* main() : test case ( [4,1,2,1], 4, 2 )
int main()
{
	vector<int> numbers = { 4, 1, 2, 1 };
	int target = 4;

	cout << solution(numbers, target);
}
*/