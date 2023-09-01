#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;

    for (const auto& skill_tree : skill_trees) {
        unordered_map<char, int> skill_order;
        int order = 0;

        for (const char& c : skill) {
            skill_order[c] = order++;
        }

        int cur_order = 0;
        bool is_possible = true;

        for (const char& c : skill_tree) {
            if (skill_order.find(c) != skill_order.end()) {
                if (skill_order[c] == cur_order) {
                    cur_order++;
                }
                else {
                    is_possible = false;
                    break;
                }
            }
        }

        if (is_possible) {
            answer++;
        }
    }

    return answer;
}