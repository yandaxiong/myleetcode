package com.xiong.top100;

/**
 * @author xiong
 * @Description
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。

 */
public class a8_string_to_integer_atoi {
    public static void main(String[] args) {
        int i = myAtoi("-+42");
        System.out.println(i);

    }
    public static  int myAtoi(String s) {
        if(s.trim().length()==0){
            return 0;
        }
        String trim = s.trim();
        boolean isNegativeNumber = false;
        if(trim.charAt(0) == '-'){
            isNegativeNumber = true;
            trim = trim.substring(1);
        }else if(trim.charAt(0) == '+'){
            trim = trim.substring(1);
        }
        long result = 0;
        int i = 0;
        while (i<trim.length() && Character.isDigit(trim.charAt(i)) ){
            result = result*10 + Integer.parseInt(trim.substring(i,i+1));
            if(isNegativeNumber && result> 2147483648L){
                return Integer.MIN_VALUE;
            }
            if(!isNegativeNumber && result > 2147483647L){
                return Integer.MAX_VALUE;
            }
            i++;
        }
        return isNegativeNumber?-1*(int)result:(int) result;

    }
}
