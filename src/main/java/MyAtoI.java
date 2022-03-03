public class MyAtoI {

//    读入字符串并丢弃无用的前导空格
//    检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
//    读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
//    将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
//    如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
//    返回整数作为最终结果。

    public int myAtoi(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int pos = 0;
        while (s.charAt(pos)==' '){
            pos ++;
            if(s.length() <= pos){
                return 0;
            }
        }
        int sign = 1;
        if (s.charAt(pos) == '+'){
            sign = 1;
            pos ++;
        }else if (s.charAt(pos) == '-'){
            sign = -1;
            pos ++;
        }
        int num = 0;
        boolean isOver = false;
        while (s.length() > pos && '0'<= s.charAt(pos) && s.charAt(pos) <= '9'){
            if (Integer.MIN_VALUE / 10 > num || Integer.MAX_VALUE / 10 < num){
                isOver = true;
                break;
            }
            num = (num * 10 + sign * (int)(s.charAt(pos) - '0'));

            pos ++;
        }
        return num;
    }
}
