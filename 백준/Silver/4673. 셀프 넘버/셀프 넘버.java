public class Main {
    public static void main(String[] args) {
        int SelfNum = 1;
        while(SelfNum <= 10000) {
            if(isSelfNumber(SelfNum))
                System.out.println(SelfNum);
            SelfNum++;
        }
    }

    static boolean isSelfNumber(int SF) {
        if(SF < 10)
            return SF % 2 != 0;
        for(int CmpNum = 1; CmpNum < SF; CmpNum++) {
            int i = CmpNum;
            for(int digit = 1; (CmpNum / digit) > 0; digit *= 10) {
                i += (CmpNum % (digit * 10)) / digit;
            }
            if(i == SF)
                return false;
        }
        return true;
    }
}
