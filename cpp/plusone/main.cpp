#include <vector>
#include <iostream>

using namespace std;

vector<int> plusOne(vector<int>& digits) {
    int remainder = 1;
    for (int i = digits.size() - 1; i >= 0 ; i--) {
        int sum = digits[i] + remainder;

        if (sum == 10){
            digits[i] = 0;
            remainder = 1;
        } else {
            digits[i] = sum;
            remainder = 0;
        }
    }
    if (remainder == 1) {
        digits.insert(digits.begin(), 1);
    }
    return digits;
}

void print(const vector<int>& digits) {
    for (int i = 0; i < digits.size(); i++) {
        cout << digits[i];
    }
    cout << endl;
}

int main(){
    vector<int> digits = {9,9,9,9};
    print(plusOne(digits));
    return 0;
}