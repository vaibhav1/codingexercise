package com.vaibhav1.codingexercise.company.facebook;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid and return any valid string.
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 *
 * Example 2:
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 *
 * Example 3:
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 *
 * Example 4:
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 */
public class MinRemoveValidParantheses {

    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder();

        int open = 0;

        for(char c : s.toCharArray()){

            if( c == '('){
                open ++;
            } else if(c ==')'){

                if(open == 0 ){
                    continue;
                }
                open --;
            }

            sb.append(c);
        }

        if(open == 0){
            return sb.toString();
        }

        StringBuilder result = new StringBuilder();

        for(int i = sb.length() - 1; i >= 0; i--){

            if(sb.charAt(i) == '(' && open > 0){
                open --;
                continue;
            }

            result.append(sb.charAt(i));

        }

        return result.reverse().toString();
    }

}
