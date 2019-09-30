import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private HashMap<Character, char[]> map;
    private String digits;
    public LetterCombinationsOfAPhoneNumber(){
        map = new HashMap<Character, char[]>();
        char[] two = {'a', 'b', 'c'};
        char[] three = {'d', 'e', 'f'};
        char[] four = {'g', 'h', 'i'};
        char[] five = {'j', 'k', 'l'};
        char[] six = {'m', 'n', 'o'};
        char[] seven = {'p', 'q', 'r', 's'};
        char[] eight = {'t', 'u', 'v'};
        char[] nine = {'w', 'x', 'y', 'z'};
        map.put('2', two);
        map.put('3', three);
        map.put('4', four);
        map.put('5', five);
        map.put('6', six);
        map.put('7', seven);
        map.put('8', eight);
        map.put('9', nine);
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<String>();
        }
        this.digits = digits;
        return findStr("", 0);
    }

    private ArrayList<String> findStr(String now, int pos){
        ArrayList<String> res = new ArrayList<String>();
        for (char c : map.get(digits.charAt(pos))){
            String temp = now + c;
            if (pos == digits.length() - 1){
                res.add(temp);
            }else if (pos < digits.length() - 1){
                res.addAll(findStr(temp, pos + 1));
            }
        }
        return res;
    }

    public static void main(String[] args){
        LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
        System.out.println(sol.letterCombinations("23"));
    }
}
