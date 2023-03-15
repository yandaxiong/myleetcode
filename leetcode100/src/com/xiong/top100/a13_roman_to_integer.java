package com.xiong.top100;

/**
 * @author xiong
 * @Description  罗马数字转整数
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1 。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数
 * @date 2023-02-23 2:21 下午
 */
public class a13_roman_to_integer {
    public static void main(String[] args) {
        String a = "IV";
        System.out.println(romanToInt(a));
    }
    public static int romanToInt(String s) {
        int result = 0;
        for (int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = ' ';
            if(i<s.length()-1) {
                c2 = s.charAt(i+1);
            }
            if(c1 == 'I' ){
                if(c2 =='V'){
                    result = result + 4;
                    i++;
                }else if(c2 == 'X'){
                    result = result + 9;
                    i++;
                }else {
                    result = result + 1;
                }
            }else if(c1 == 'V'){
                result = result + 5;
            }else if (c1 == 'X' ){
                if(c2 =='L'){
                    result = result + 40;
                    i++;
                }else if(c2 == 'C'){
                    result = result + 90;
                    i++;
                }else {
                    result = result + 10;
                }
            }else if(c1 == 'L'){
                result = result + 50;
            }else if (c1 == 'C' ){
                if(c2 =='D'){
                    result = result + 400;
                    i++;
                }else if(c2 == 'M'){
                    result = result + 900;
                    i++;
                }else {
                    result = result + 100;
                }
            }else if(c1 == 'D'){
                result = result + 500;
            }else {
                result = result + 1000;
            }
        }
        return  result;
    }


}
