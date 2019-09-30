import java.util.ArrayList;

public class RegularExpressionMatching_Star {
    public class SonReg{

        char val;
        boolean isStar;
//        int usedTimes;
//        int mustNum;
//        int start;
//        int end;
        public SonReg(char c){
            val = c;
            isStar = false;
//            usedTimes = 0;
//            mustNum = 0;
//            start = -1;
//            end = -1;
        }
    }
    public boolean isMatch(String s, String p){
        //找出所有规则
        ArrayList<SonReg> regs = new ArrayList<SonReg>();
        int pastReg = -1;
        for (int i = 0;i < p.length();i ++){
            char temp = p.charAt(i);
            if (temp == '*'){
                regs.get(pastReg).isStar = true;
            }else {
                SonReg reg = new SonReg(temp);
                regs.add(reg);
                pastReg++;
            }
        }
        if (pastReg == -1){
            if (s.length() == 0) {
                return true;
            }else {
                return false;
            }
        }
        if (s.length() == 0){
            for (int i = 0;i < regs.size();i ++){
                if (!regs.get(i).isStar){
                    return false;
                }
            }
            return true;
        }
        //dp[i-1][j-1]表示前i个字符和前j个规则是否匹配
        boolean[][] dp = new boolean[s.length()][regs.size()];
        int pastFirst = 0;
        int pastLast = regs.size() - 1;
        for (int i = 0;i < s.length();i ++){
            char temp = s.charAt(i);
            boolean isFirst = false;
            boolean flag = false;
            boolean isUsed = false;
            boolean isMustUsed = false;
            for (int j = pastFirst;j < regs.size();j ++){
                if (j > pastLast + 1){
                    break;
                }
                SonReg tempReg = regs.get(j);
                //第一个字符
                if (i == 0){
                    //如果带星
                    if (tempReg.isStar){
                        dp[i][j] = true;
                        if (!isFirst){
                            pastFirst = j;
                            isFirst = true;
                        }
                        if (tempReg.val == temp || tempReg.val == '.'){
                            isUsed = true;
                        }
                        pastLast = (j > pastLast) ? j : pastLast;
                    }//如果不带星
                    else {
                        if (flag){
                            break;
                        }
                        if (tempReg.val == '.' || tempReg.val == temp){
                            dp[i][j] = true;
                            flag = true;
                            if (!isFirst){
                                pastFirst = j;
                                isFirst = true;
                            }
                            isUsed = true;
                            pastLast = (j > pastLast) ? j : pastLast;
                            continue;
                        }
                        break;
                    }
                }
                //非第一个字符
                else {
                    //判断上一个字符通过上一规则是否可到达
                    if (j >= 1 && dp[i - 1][j - 1]){
                        if(tempReg.val == temp || tempReg.val == '.'){
                            dp[i][j] = true;
                            if (!isFirst){
                                isFirst = true;
                                pastFirst = j;
                            }
                            isUsed = true;
                            isMustUsed = !tempReg.isStar;
                            pastLast = (j > pastLast) ? j : pastLast;
                            continue;
                        }
                    }
                    //判断上一个字符通过本规则是否可到达
                    if(dp[i - 1][j]){
                        if (tempReg.isStar && (tempReg.val == temp || tempReg.val == '.')){
                            dp[i][j] = true;
                            if (!isFirst){
                                pastFirst = j;
                                isFirst = true;
                            }
                            isUsed = true;
                            pastLast = (j > pastLast) ? j : pastLast;
                            continue;
                        }
                    }
                    //判断上一条规则是否可到达
                    if(j > 0 && dp[i][j - 1]){
                        if (tempReg.isStar) {
                            if ((tempReg.val == temp || tempReg.val == '.') || (isUsed)) {
                                dp[i][j] = true;
                                if (!isFirst) {
                                    pastFirst = j;
                                    isFirst = true;
                                }
                                isUsed = true;
                                pastLast = (j > pastLast) ? j : pastLast;
                            }
                        }else {
                            if (!isMustUsed && (tempReg.val == temp || tempReg.val == '.')){
                                dp[i][j] = true;
                                dp[i][j] = true;
                                if (!isFirst) {
                                    pastFirst = j;
                                    isFirst = true;
                                }
                                isUsed = true;
                                pastLast = (j > pastLast) ? j : pastLast;
                            }
                        }

                    }
                }

            }
            if (!isUsed){
                return false;
            }
        }
        return dp[s.length() - 1][regs.size() - 1];
    }

    public static void main(String[]args){
        RegularExpressionMatching_Star sol = new RegularExpressionMatching_Star();
        System.out.println(sol.isMatch("bbcbbcbcbbcaabcacb", "a*.*ac*a*a*.a..*.*"));
                                         //0123456789               //012345 6789a bcdef ghijk l
        //"aasdfasdfasdfasdfas"
        //"aasdf.*asdf.*asdf.*asdf.*s"
    }
}

//                        }else if (regs.get(j - 1).isStar){
//                            if (tempReg.val == temp || tempReg.val == '.'){
//                                dp[i][j] = true;
//                                if (!isFirst) {
//
//                                    pastFirst = j;
//                                    isFirst = true;
//
//                                }
//                                isUsed = true;
//                                pastLast = (j > pastLast) ? j : pastLast;
//                            }
//                        }