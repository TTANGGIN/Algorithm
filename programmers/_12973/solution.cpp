#include <string>
#include <stack>

using namespace std;

int solution(string s)
{
	stack<char> s_stack;
	s_stack.push(s.at(0));

	for (int i = 1; i < s.size(); ++i)
	{
		if (!s_stack.empty() && s_stack.top() == s.at(i))
		{
			s_stack.pop();
		}
		else
		{
			s_stack.push(s.at(i));
		}
	}

	return s_stack.empty() ? 1 : 0;
}