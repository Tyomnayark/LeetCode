#include<iostream>
#include<vector>

using namespace std;

template<typename T>
void reverseArray(vector<T>* arrayLink){
    int size = arrayLink -> size();
    T* startValue = arrayLink -> data();
    T* endValue = startValue + size - 1;

    while (startValue < endValue) {
       swap(*startValue, *endValue);

        --endValue;
        ++startValue;
    }
}

template<typename T>
void printArray(vector<T> array){
    for (unsigned int i = 0; i < array.size(); i++) {
       cout << array[i] << " ";
    }
    cout << endl;
}

int main () {
    vector<int> arrayTest = {1,2,3,4,5,6,7};

    cout<<"Original array: "<< endl;
    printArray(arrayTest);

    reverseArray(&arrayTest);
    cout<<"Reversed array: "<< endl;
    printArray(arrayTest);

    return 0;
}