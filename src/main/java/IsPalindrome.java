import java.util.ArrayList;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        ArrayList<Integer> xStr = new ArrayList<Integer>();
        while (x > 0){
            int lastNum = x % 10;
            xStr.add(lastNum);
            x /= 10;
        }
        for (int i = 0; i < xStr.size() / 2; i++){
            if (xStr.get(i) != xStr.get(xStr.size() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
