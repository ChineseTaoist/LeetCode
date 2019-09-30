import java.util.ArrayList;
import java.util.HashMap;

public class IntegerToRoman {
    private HashMap<Integer, Character> numMap;
    public IntegerToRoman(){
        numMap = new HashMap<Integer, Character>();
        numMap.put(1, 'I');
        numMap.put(5, 'V');
        numMap.put(10, 'X');
        numMap.put(50, 'L');
        numMap.put(100, 'C');
        numMap.put(500, 'D');
        numMap.put(1000, 'M');
    }
    public String intToRoman(int num) {
        StringBuffer numStr = new StringBuffer();
        int[] keys = {1, 5, 10, 50, 100, 500, 1000};
        //  left -> true  right -> false
        while (num / keys[keys.length - 1] > 0){
            numStr.append(numMap.get(keys[keys.length - 1]));
            num -= keys[keys.length - 1];
        }
        for (int i = keys.length - 3;i >= 0;i -= 2){
            StringBuffer tempStr = new StringBuffer();

            int times = num / keys[i];
            if (times > 0 && times <= 3){
                num -= times * keys[i];
                while (times > 0){
                    tempStr.append(numMap.get(keys[i]));
                    times --;
                }
            }else if (times > 3 && times <= 5){
                num -= times * keys[i];
                times = 5 - times;
                while (times > 0){
                    tempStr.insert(0, numMap.get(keys[i]));
                    times --;
                }
                tempStr.append(numMap.get(keys[i + 1]));
            }else if (times > 5 && times <= 8){
                num -= times * keys[i];
                times -= 5;
                tempStr.append(numMap.get(keys[i + 1]));
                while (times > 0){
                    tempStr.append(numMap.get(keys[i]));
                    times --;
                }
            }else if (times > 8 && times <= 9){
                num -= times * keys[i];
                times = 10 - times;
                while (times > 0){
                    tempStr.insert(0, numMap.get(keys[i]));
                    times --;
                }
                tempStr.append(numMap.get(keys[i + 2]));
            }
            numStr.append(tempStr);
        }
        return numStr.toString();
    }

    public static void main(String[]args){
        IntegerToRoman sol = new IntegerToRoman();
        System.out.println(sol.intToRoman(58));
    }
}
