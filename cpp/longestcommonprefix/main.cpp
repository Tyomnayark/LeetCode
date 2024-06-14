#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

string longestCommonPrefix(vector<string>& strs) {
    string prefix = strs[0];
    for (int i = 1; i < strs.size(); i++){
        while(strs[i].find(prefix) != 0){
            prefix.pop_back();
        }
    }
    return prefix;
}

int main() {
    return 0;
}