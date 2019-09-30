import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    private StringBuffer str;
    private List<String> res;
    private int size = -1;
    private int numOfleft = 0;

    {
        str = new StringBuffer();
        res = new ArrayList<String>();
    }

    public List<String> generateParenthesis(int n) {
        if (size == -1){
            size = n;
        }
        if (n > 1) {
            str.append('(');
            int start = str.length() - 1;
            numOfleft ++;
            generateParenthesis(n - 1);
            int count = 0;
            while (0 < numOfleft) {
                str.append(')');
                numOfleft --;
                generateParenthesis(n - 1);
                count ++;
            }
            int end = str.length();
            if (start <= end){
                str.delete(start, end);
                numOfleft += (count - 1);
            }
        }else {
            int start = str.length();
            str.append('(');
            while (str.length() < 2 * size){
                str.append(')');
            }
            int end = str.length();
            res.add(str.toString());
            str.delete(start, end);
        }

        return res;
    }
    public static void main(String[] args){
        GenerateParentheses sol = new GenerateParentheses();

        System.out.println(sol.generateParenthesis(3));
    }
}
