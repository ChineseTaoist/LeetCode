import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {
    public int myAtoi(String str) {
        int start = -1;

        boolean zOrF = true;
        for (int i = 0;i < str.length();i ++){
            char temp = str.charAt(i);
            if (temp != ' '){
                if (temp == '-'){
                    if(i + 1 < str.length() && !(str.charAt(i + 1) <= '9' && str.charAt(i + 1) >= '0')){
                        return 0;
                    }
                    zOrF = false;
                }else if (temp == '+'){
                    if(i + 1 < str.length() && !(str.charAt(i + 1) <= '9' && str.charAt(i + 1) >= '0')){
                        return 0;
                    }
                    zOrF = true;
                }
                else if(temp <= '9' && temp >= '0'){
                    if(temp == '0'){
                        if(i + 1 < str.length() && !(str.charAt(i + 1) <= '9' && str.charAt(i + 1) >= '0')){
                            return 0;
                        }
                        continue;
                    }
                    start = i;
                    break;
                }else{
                    return 0;
                }
            }
        }
        if (start == -1){
            return 0;
        }
        int end = -1;
        for (int i = start;i < str.length();i++){
            char temp = str.charAt(i);
            if (temp >= '0' && temp <= '9'){
                continue;
            }
            end = i - 1;
            break;
        }
        if (end == -1){
            end = str.length() - 1;
        }
        String max = "2147483647";
        String min = "2147483648";

        if (end - start > 9){
            return zOrF ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else if (end - start == 9){
            for (int i = start;i <= end; i ++){
                if (i == end - 1){
                    if(str.charAt(i) >= '8'){
                        return zOrF ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                }
                if (str.charAt(i) > max.charAt(i - start)){
                    return zOrF ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }else if(str.charAt(i) == max.charAt(i - start)){
                    continue;
                }else{
                    break;
                }
            }
        }
        int res = 0;
        for (int i = start;i <= end;i ++){
            if (zOrF) {
                res += (str.charAt(i) - '0') * (int) Math.pow(10, end - i);
            }else {
                res -= (str.charAt(i) - '0') * (int) Math.pow(10, end - i);
            }
        }
        return res;
    }


    public int myAtoi2(String str){
        String regex = "(\\s*)([+-]*)(\\d+)(.*)";
        String regexNum = "([+-]*)(\\d+)";
        if (!Pattern.matches(regex, str)){
            return 0;
        }
        Pattern pattern = Pattern.compile(regexNum);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            String num = matcher.group(0);
            boolean zOrF = true;
            if (num.charAt(0) == '-') {
                zOrF = false;
            }
            int res = 0;
            for (int i = 0; i < num.length(); i++) {
                char temp = num.charAt(i);
                if (temp <= '9' && temp >= '0') {
                    res += (temp - '0') * Math.pow(10, num.length() - i - 1);
                }
            }
            res *= zOrF ? 1 : -1;
            return res;
        }else {
            return 0;
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringToInteger sol = new StringToInteger();
        System.out.println(sol.myAtoi2(str));

    }
}
