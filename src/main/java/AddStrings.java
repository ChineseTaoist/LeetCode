public class AddStrings {
    public String addStrings(String num1, String num2) {
        int pos1 = num1.length() - 1;
        int pos2 = num2.length() - 1;
        String res = "";
        boolean isUp = false;
        while (pos1 >= 0 || pos2 >= 0){
            int temp;
            if (pos1 < 0){
                temp = num2.charAt(pos2--) - '0';
            }else if (pos2 < 0){
                temp = num1.charAt(pos1--) - '0';
            }else {
                temp = (int) num1.charAt(pos1--) + (int) num2.charAt(pos2--) - '0' - '0';
            }
            temp += isUp ? 1 : 0;

            if (temp >= 10){
                isUp = true;
                temp -= 10;
            }else {
                isUp = false;
            }
            res = (temp + res);
        }
        if (isUp){
            res = (1 + res);
        }
        return res;
    }
    public static void main(String[] args){
        AddStrings addStrings = new AddStrings();
        addStrings.addStrings("456", "77");

    }
}
