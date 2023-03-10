package calculator;

import java.util.Scanner;

public class String {
    static int add(int a, int b)
    {
        return a + b;
    }
    static int sub (int a, int b)
    {
        return a - b;
    }
    static int mul (int a, int b)
    {
        return a * b;
    }
    static int div (int a, int b)
    {
        return a / b;
    }
    static int calculator(int num1, char arith, int num2)
    {
        int result = 0;

        switch(arith)
        {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = sub(num1, num2);
                break;
            case '*':
                result = mul(num1, num2);
                break;
            case '/':
                result = div(num1, num2);
                break;
        }
        return result;
    }

    public static void main(java.lang.String[] args) {
        int result = 0;
        System.out.print("Input String : ");
        Scanner in = new Scanner(System.in);
        java.lang.String s_input = in.next();
        //숫자 split
        java.lang.String[] ArraysStrArith = s_input.split("[0-9]+");
        //사칙연산 부호 split
        java.lang.String[] ArraysStrNum = s_input.split("[+\\-*/]");

        for(int i = 1; i < ArraysStrNum.length-1; i++)
        {
            if(i == 1)
                result = Integer.valueOf(ArraysStrNum[0]);
            result = calculator(result, ArraysStrArith[i].charAt(0), Integer.valueOf(ArraysStrNum[i]));
        }
        System.out.println("결과 :"+result);
    }
}


