package tasks.validparentheses;

import java.util.ArrayList;

public class ValidParentheses {
    static public boolean isValid(String s){
       char[] chars = s.toCharArray();
        ArrayList<Character> brackets = new ArrayList<>();

        if (chars.length%2!=0){
            return false;
        }
        for (int i = 0; i< chars.length; i++ ){

            switch (chars[i]){
                case '(' : brackets.add('(');
                    break;
                case ')' :
                    if (brackets.isEmpty()){
                        return false;
                    }
                    if (brackets.get(brackets.size()-1) != '('){
                    return false;
                }
                brackets.remove(brackets.size()-1);
                    break;
                case '[' :brackets.add('[');
                    break;
                case ']' :
                    if (brackets.isEmpty()){
                        return false;
                    }
                    if (brackets.get(brackets.size()-1) != '['){
                        return false;
                    }
                    brackets.remove(brackets.size()-1);
                    break;
                case '{' :brackets.add('{');
                    break;
                case '}' :
                    if (brackets.isEmpty()){
                        return false;
                    }
                    if (brackets.get(brackets.size()-1) != '{'){
                        return false;
                    }
                    brackets.remove(brackets.size()-1);
                    break;
                default: continue;
            }
        }
        if (brackets.isEmpty()) {
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
