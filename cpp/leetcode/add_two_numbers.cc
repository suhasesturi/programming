#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

struct ListNode {
    int val;
    ListNode* next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class Solution {
   public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* current = new ListNode();
        ListNode* temp = current;
        int sum = 0, carry = 0, first, second;
        while (l1 != nullptr || l2 != nullptr || carry != 0) {
            if (l1 != nullptr) {
                first = l1->val;
                l1 = l1->next;
            } else {
                first = 0;
            }
            
            if (l2 != nullptr) {
                second = l2->val;
                l2 = l2->next;
            } else {
                second = 0;
            }
            sum = carry + first + second;
            current->next = new ListNode(sum % 10);
            carry = sum / 10;
            current = current->next;
        }

        return temp->next;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
    }
    return 0;
}
