import java.util.Scanner;

public class ZigZagConversion {
    public String convert(String s, int numRows){
        if (s.length() == 0){
            return s;
        }
        if (numRows == 1){
            return s;
        }
        StringBuffer[] stringBuffers = new StringBuffer[numRows];
        for (int i = 0;i < numRows;i ++){
            stringBuffers[i] = new StringBuffer();
        }
        int currentRow = 0;
        boolean upOrDown = false;
        for (int i = 0;i < s.length();i ++){
            //上
            if (upOrDown){
                stringBuffers[currentRow].append(s.charAt(i));
                if (currentRow > 0){
                    currentRow --;
                }else {
                    currentRow ++;
                    upOrDown = false;
                }
            }
            //下
            else {
                stringBuffers[currentRow].append(s.charAt(i));
                if(currentRow < numRows - 1){
                    currentRow ++;
                }else {
                    currentRow --;
                    upOrDown = true;
                }
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0;i < stringBuffers.length;i ++){
            for (int j = 0;j < stringBuffers[i].length();j ++){
                res.append(stringBuffers[i].charAt(j));
            }
        }
        return res.toString();

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        ZigZagConversion sol = new ZigZagConversion();
        sol.convert(str, n);
    }
}
