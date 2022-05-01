#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class PrimeAnagrams {
   private:
    static constexpr int INF = 1e6 + 10;
    int min = INT32_MAX;
    vector<int> result;
    vector<int> prime_vector;

    void CalculatePrimes(int max) {
        prime_vector.push_back(2);
        for (int i = 3; i <= max; i += 2) {
            if (IsPrime(i)) {
                prime_vector.push_back(i);
            }
        }
    }

    bool IsPrime(int n) {
        if (n <= 1) return false;
        int max = sqrt(n);
        for (int i = 0; i < prime_vector.size() && prime_vector[i] <= max;
             i++) {
            if (n % prime_vector[i] == 0) {
                return false;
            }
        }
        return true;
    }

    void ValidatePrimes(string first, string second, string third) {
        if (first[0] == '0' || second[0] == '0' || third[0] == '0') return;
        int x = stoi(first);
        int y = stoi(second);
        int z = stoi(third);
        if (IsPrime(x) && IsPrime(y) && IsPrime(z) && (x * y * z < min)) {
            min = x * y * z;
            result[0] = x;
            result[1] = y;
            result[2] = z;
        }
    }

    void PermuteAndCalculate(string anagram, int start, int end) {
        if (start == end) {
            for (int i = 1; i < end; i++) {
                for (int j = i + 1; j < end; j++) {
                    ValidatePrimes(anagram.substr(0, i),
                                   anagram.substr(i, j - i),
                                   anagram.substr(j, end));
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                swap(anagram, start, i);
                PermuteAndCalculate(anagram, start + 1, end);
                swap(anagram, start, i);
            }
        }
    }

    void swap(string &s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

   public:
    PrimeAnagrams() : result(3) { CalculatePrimes(INF); }

    vector<int> primes(string anagram) {
        PermuteAndCalculate(anagram, 0, anagram.length());
        sort(result.begin(), result.end());
        return (min != INT32_MAX) ? result : vector<int>();
    }
};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    PrimeAnagrams p;
    vector<int> result = p.primes(s);
    cout << result[0] << " " << result[1] << " " << result[2] << endl;

    return 0;
}
