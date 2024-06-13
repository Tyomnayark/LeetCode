#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> generate(int numRows) {
    vector<vector<int>> triangle;
    vector<int> firstRow = {1};
    triangle.push_back(firstRow);

    for (int i = 1; i < numRows; i++){
        vector<int> prevRow = triangle[i - 1];
        vector<int> nextRow;
        for (int j = 0; j < prevRow.size() + 1; j++ ){
            if (j == 0 || j == prevRow.size()){
                nextRow.push_back(1);
            } else {
                nextRow.push_back(prevRow[j] + prevRow[j-1]);
            }
        }
        triangle.push_back(nextRow);
    }

    return triangle;
}

void print(vector<vector<int>> triangle ){
    for (int i = 0; i < triangle.size(); i++){
        for (int j = 0; j < triangle[i].size(); j++){
            cout << triangle[i][j];
        }
         cout << endl;
    }
}

int main(){
    print(generate(10));
    return 0;
}