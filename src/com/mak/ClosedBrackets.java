package com.mak;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ClosedBrackets {

    private static final Set<String> OPEN_BRACKETS = Set.of("{", "[", "(");
    private static final Set<String> CLOSED_BRACKETS = Set.of("}", "]", ")");
    private static final Map<String, String> PAIR_BRACKETS = Map.of("{", "}", "(", ")", "[", "]");
    public static void main(String[] args) {
        System.out.println("Expression is " + (isValid("{[()]}") ? "valid" : "invalid"));
        System.out.println("Expression is " + (isValid("{[()]]}") ? "valid" : "invalid"));
        System.out.println("Expression is " + (isValid("{") ? "valid" : "invalid"));
        System.out.println("Expression is " + (isValid("}") ? "valid" : "invalid"));
    }

    private static boolean isValid(String expression) {
        var tokenized = expression.split("");
        Stack<String> stack = new Stack<>();
        for(var token : tokenized) {
            if (OPEN_BRACKETS.contains(token)) {
                stack.push(token);
            } else if(CLOSED_BRACKETS.contains(token)) {
                if(stack.isEmpty() || !token.equals(PAIR_BRACKETS.get(stack.pop()))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
