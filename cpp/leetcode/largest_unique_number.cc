#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
   public:
    int largestUniqueNumber(vector<int>& A) {
        sort(A.begin(), A.end());
        for (int i = A.size() - 1; i >= 0; i--) {
            int count = 1;
            int current = A[i];
            while (i > 0 && A[i - 1] == current) {
                count++;
                i--;
            }
            if (count == 1) return current;
        }
        return -1;
    }
};
