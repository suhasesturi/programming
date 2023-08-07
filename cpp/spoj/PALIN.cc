#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    string number;
    while (t-- > 0) {
        cin >> number;
        bool updated = false;
        for (int i = (number.length() - 1) / 2, j = number.length() / 2;
             i >= 0 && j < number.length(); i--, j++) {
            if (number[i] == number[j]) {
                continue;
            } else if (updated || number[i] > number[j]) {
                number[j] = number[i];
            } else {
                bool updated_middle = false;
                for (int k = (number.length() - 1) / 2, l = number.length() / 2;
                     k > i && l < j; k--, l++) {
                    if (number[k] != '9') {
                        number[k]++;
                        number[l] = number[k];
                        updated_middle = true;
                        break;
                    } else {
                        number[k] = '0';
                        number[l] = '0';
                    }
                }
                if (updated_middle) {
                    number[j] = number[i];
                } else {
                    number[i]++;
                    number[j] = number[i];
                }
            }
            updated = true;
        }
        if (updated) {
            cout << number << "\n";
        } else {
            bool bigger = false;
            for (int i = (number.length() - 1) / 2, j = number.length() / 2;
                 i >= 0 && j < number.length(); i--, j++) {
                if (number[i] != '9') {
                    number[i]++;
                    number[j] = number[i];
                    bigger = true;
                    break;
                } else {
                    number[i] = '0';
                    number[j] = '0';
                }
            }
            if (!bigger) {
                number = '1' + number;
                number[number.length() - 1] = '1';
            }
            cout << number << "\n";
        }
    }
    return 0;
}
