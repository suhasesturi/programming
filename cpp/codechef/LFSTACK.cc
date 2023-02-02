#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

unordered_map<int, vector<int>> map;

void add_to_map(int key, int index) {
    auto pair = map.find(key);
    if (pair != map.end()) {
        pair->second.push_back(index);
    } else {
        map.insert({key, {index}});
    }
}

void remove_from_map(int key, int index) {
    auto pair = map.find(key);
    if (pair != map.end()) {
        pair->second.pop_back();
        if (pair->second.empty()) {
            map.erase(key);
        }
    }
}

bool valid(vector<stack<int>>& threads, vector<int>& output, int index) {
    if (index == output.size()) {
        return true;
    }
    auto pair = map.find(output[index]);
    if (pair == map.end()) {
        return false;
    }
    for (int j = 0; j < pair->second.size(); j++) {
        int current_thread = pair->second[j];
        if (current_thread == -1) {
            continue;
        }
        threads[current_thread].pop();
        int next_element = -1;
        if (!threads[current_thread].empty()) {
            next_element = threads[current_thread].top();
            add_to_map(next_element, current_thread);
        }
        pair->second[j] = -1;

        bool is_valid = valid(threads, output, index + 1);
        
        if (is_valid) {
            return true;
        } else {
            pair->second[j] = current_thread;
            if (next_element != -1) {
                remove_from_map(next_element, current_thread);
            }
            threads[current_thread].push(output[index]);
        }
    }
    return false;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    while (t--) {
        int n, temp, total = 0;
        cin >> n;
        vector<stack<int>> threads;
        for (int i = 0; i < n; i++) {
            int size;
            cin >> size;
            total += size;
            stack<int> st;
            for (int j = 0; j < size; j++) {
                cin >> temp;
                st.push(temp);
            }
            threads.push_back(st);
        }
        vector<int> output(total);
        for (int i = 0; i < total; i++) {
            cin >> output[i];
        }
        for (int i = 0; i < n; i++) {
            add_to_map(threads[i].top(), i);
        }
        cout << (valid(threads, output, 0) ? "Yes" : "No") << "\n";
        map.clear();
    }
    return 0;
}
