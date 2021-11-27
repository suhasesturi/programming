#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int nums[n];
        for (int i = 0; i < n; ++i) {
            cin >> nums[i];
        }
        int index = -1;
        for (int i = n - 1; i > 0; --i) {
            if (nums[i] > nums[i - 1]) {
                for (int j = n - 1; j >= i; --j) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums[j], nums[i - 1]);
                        break;
                    }
                }
                index = i - 1;
                break;
            }
        }
        if (index != -1) {
            for (int i = n - 1, j = index + 1; i > j; --i, j++) {
                swap(nums[i], nums[j]);
            }
            for (int i = 0; i < n; ++i) {
                cout << nums[i];
            }
            cout << "\n";
        } else {
            cout << "-1\n";
        }
    }

    return 0;
}
