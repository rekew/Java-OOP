import java.util.ArrayDeque;
import java.util.Deque;

public class ParenMatcher {

    public static boolean processLine(String s){
        Deque<Character> stack = new ArrayDeque<>();
        char[] curLine;

        stack.clear();
        curLine = s.toCharArray();

        for(char c : curLine){
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.size() > 0){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                    break;
            }
        }

        if (stack.size() > 0){
            return false;
        }
        else return true;
    }
    public static void main(String[] args){
        String[] testCases = {
            "(a + b) * (c + d)",  
            "(a + b * (c + d)",   
            "((a + b))",          
            "())(",               
            "(a + (b + (c + d)))" 
        };

        for(int i = 0; i < testCases.length; ++i){
            boolean res = processLine(testCases[i]);
            System.out.println("Line " + i + " is " + (res ? "valid" : "invalid"));
        }
    }
}
