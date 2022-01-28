package com.ahmet;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int num = trailingZeroes(125);
        System.out.println(num);
    }

//    Trailing zeroes in factorial
//For an integer N find the number of trailing zeroes in N!.
//
//    Example 1:
//
//    Input:
//    N = 5
//    Output:
//            1
//    Explanation:
//            5! = 120 so the number of trailing zero is 1.
//    Example 2:
//
//    Input:
//    N = 4
//    Output:
//            0
//    Explanation:
//            4! = 24 so the number of trailing zero is 0.
    static int trailingZeroes(int N){
        if(N==0) return 0;
        return N/5 + trailingZeroes(N/5);
    }

}
