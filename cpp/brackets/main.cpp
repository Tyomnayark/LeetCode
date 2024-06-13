#include <string>
#include <iostream>
#include <list>

using namespace std;

bool isValid(string s) {
    list<char> chars;

    for(char ch: s){
        if (ch == '('){
            chars.push_front(')');
        }
        if (ch == '['){
            chars.push_front(']');
        }
        if (ch == '{'){
            chars.push_front('}');
        }
        if (ch == ')'){
            if (chars.front() == ')'){
                chars.pop_front();
            } else{
                return false;
            }
        }
        if (ch == ']'){
              if (chars.front() == ']'){
                chars.pop_front();
            } else{
                return false;
            }
        }
        if (ch == '}'){
              if (chars.front() == '}'){
                chars.pop_front();
            } else{
                return false;
            }
        }
    }
    
    if (!chars.empty()){
        return false;
    }
    return true;
}

int main(){
     bool result = isValid("[(]}");
     cout << "[(]}: " << (result ? "true" : "false") << endl;
     
     result = isValid("[()]}");
     cout << "[()]}: " << (result ? "true" : "false") << endl;  

     result = isValid("[()]");
     cout << "[()]: " << (result ? "true" : "false") << endl;          

     result = isValid("[]");
     cout << "[]: " << (result ? "true" : "false") << endl;       
 
     return 0;
}
