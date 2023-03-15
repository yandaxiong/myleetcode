package com.xiong.top100;

/**
 * @author xiong
 * @Description
 * @date 2023-02-21 9:21 下午
 */
public class a7_reverse_integer {
    public static void main(String[] args) {
        int reverse = reverse(-120);
        System.out.println(reverse);

    }
    public static  int reverse(int x) {
        int result = 0;
        int oldresult = 0;
        if(x==0){
            return 0;
        }
        while (x!=0){
            int remainder = x%10;
            oldresult = result;
            result = result*10+remainder;
            if(result/10 != oldresult ){
                return 0;
            }
            x = x/10;
        }
        return result;


    }
}
