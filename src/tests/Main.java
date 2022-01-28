package tests;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Operation o = (a,b) -> {
//            return a+b;
//        };
//        int number = o.calculate(56,14);
//        System.out.println(number);
//
//        o =  (a,b) ->{return a-b; };
//        int number2 = o.calculate(56,16);
//        System.out.println(number2);
//
//        Operation square = new Operation() {
//            @Override
//            public int calculate(int a, int b) {
//                return a * a;
//            }
//        };
//
//        //Operation square = (a,b) -> {return a*a;};
//
//        int num3 = square.calculate(5,6);
//        System.out.println(num3);
//        String s = "";
//        s.length();

        int num = trailingZeroes(125);
        System.out.println(num);
    }

    static int MissingNumber(int array[], int n) {

        Arrays.sort(array);
        if(array[0]!=1) return 1;
        int num = 1;
        for (int i = 0; i < array.length; i++){
           if(array[i] != num) return  num;
           num++;
        }
        return num;
    }

    static int trailingZeroes(int N){
        if(N==0) return 0;
        return N/5 + trailingZeroes(N/5);
    }

}
