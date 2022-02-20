import java.util.Stack;

// 20
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']'){
                char targetChar;
                if (s.charAt(i) == '}') targetChar = '{';
                else if (s.charAt(i) == ')') targetChar = '(';
                else targetChar = '[';
                if (stack.peek() == targetChar){
                    stack.pop();
                }else {
                    return false;
                }
            }

        }
        return stack.empty();
    }
}
