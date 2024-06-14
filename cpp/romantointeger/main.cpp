#include <iostream>
#include <map>
#include <string>

using namespace std;

int romanToInt(string s) {
map<char, int> romans;
romans['I'] = 1;
romans['V'] = 5;
romans['X'] = 10;
romans['L'] = 50;
romans['C'] = 100;
romans['D'] = 500;
romans['M'] = 1000;

int n = s.length();
int result = 0;
      for (int i = 0; i < n; ++i) {
        if (i < n - 1 && romans[s[i]] < romans[s[i + 1]]) {
            result -= romans[s[i]];
        } else {
            result += romans[s[i]];
        }
    }
    return result;    
}

int main(){
    return 0;
}