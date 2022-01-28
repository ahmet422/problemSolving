package tests;

import java.util.Arrays;

public class Problems {
//    public static void main(String[] args) {
//        System.out.println("Hey");
//        //System.out.println(numberOfDivisors(8));
//        //System.out.println(order("a2ha hsh3 h1ee"));
//        //System.out.println(accum("ZpglnRxqenU"));
//
//       // System.out.println(persistence(999));
//        // Arrays have a limited capacity
//        // create ar
//        int[] arr = new int[]{13,20,30};
//        int [] arr2 = twoSum(arr,4);
//       // System.out.println(arr2[0] + " , " + arr2[1]);
//        //System.out.println(minimumNumber(arr));
//
//        String str = "(first group) (second group) (third group)";
//
//        System.out.println(removeParentheses(str));
//
////        String [] sArr = solution(str);
////        for (String el : sArr) {
////            System.out.println(el);
////        }
//
//    }

    public static String reverseWords(final String original)
    {
        // Have at it
        char [] words = original.toCharArray();

        int leftIndex = 0;
        int rightIndex = 0;
        boolean leftIsFound = false;

        for(int i = 0; i < words.length; i++){
            if(words[i] == ' ' & leftIsFound==false){
                continue;
            }
            else if(words[i] != ' ' & leftIsFound==false){
                leftIsFound = true;
                leftIndex = i;
            }else if(words[i] == ' ' & leftIsFound==true){
                rightIndex = i-1;
                leftIndex = swap(words, leftIndex, rightIndex);
                leftIsFound = false;
            }else if(leftIsFound & i == words.length - 1){
                rightIndex = i;
                leftIndex = swap(words, leftIndex, rightIndex);
            }
        }

        String str = new String(words);
        return str;
    }

    private static int swap(char[] words, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            char temp = words[leftIndex];
            words[leftIndex] = words[rightIndex];
            words[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return leftIndex;
    }

    public static String disemvowel(String str) {
        // Code away...
        char[] ch = str.toCharArray();
        char[] ch2 = new char[str.length()];
        int index = 0;
        for(int i = 0; i < ch.length; i++){
            if(isNotVovel(ch[i])){
                ch2[index] = ch[i];
                index++;
            }
        }
        String str2 = new String(ch2);
        return str2.trim();
    }

    private static boolean isNotVovel(char character){
        if(character != 'a' & character != 'e' &  character != 'o' &  character != 'u' &  character != 'i'
                & character != 'A' & character != 'E' &  character != 'O' &  character != 'U' &  character != 'I'){
            return true;
        }
        return false;
    }

    private static long numberOfDivisors(int n) {
        int original = n;
        int count = 1;
        n = n/2;
        while(n>1){
            if(original%n==0) count++;
            n = n - 1;
        }
        count++;
        return count;
    }

    public static boolean getXO (String str) {

        char[] ch = str.toLowerCase().toCharArray();
        int count = 0;

        for (int i = 0; i < ch.length; i++){
            if(ch[i] == 'o') count++;
            if(ch[i] == 'i') count--;
        }

        return (count == 0) ? true : false;

    }

    public static String order(String words) {
        if(words.equals("") || words.equals(" ")) return "";

        String[] strArray = words.split(" ", -1);
        String[] newArr = new String[strArray.length];

        for (int i = 0; i < strArray.length; i++){
            for(Integer j = 1; j <= 9; j++){
                if(strArray[i].contains(j.toString())) {
                    newArr[j-1] = strArray[i];
                    j = 9;
                }
            }
        }
        String str1 = "";
        for (String str: newArr) {
            str1 = str1 + " " + str;
        }

        return str1.trim();
    }

    public static int roundToNext5(int number) {

        if(number%5 == 0) return number;

        if(number > 0){
            int remainder = number % 5;
            remainder = 5 - remainder;
            number = number + remainder;
        }else if(number < 0){
            number = number * (-1);
            int remainder = number % 5;
            number = number - remainder;
            number = number * (-1);
        }
        return number;
    }

    public static String accum(String s) {
        char[] ch = s.toCharArray();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < ch.length; i++){
            String st = "";
            st = st + ch[i];
            str.append(st.toUpperCase());
            int count = i;
            while(count>0){
                String st2 = "";
                st2 = st2 + ch[i];
                str.append(st2.toLowerCase());
               // str.append(ch[i]);
                count--;
            }
            if(i == ch.length - 1){
                break;
            }
            str.append("-");
        }
        return str.toString();
    }

    public static int persistence(long n) {
        int count = 0;
        if(n - 10 < 0) return count;

        while(n > 0){
            long x = 1;
            while(n > 0){
                x = x * (n%10);
                n = n / 10;
            }
            count++;
            if(x - 10 < 0) return count;
            n = x;
        }
        return count;

        //Solution
//        long m = 1, r = n;
//
//        if (r / 10 == 0)
//            return 0;
//
//        for (r = n; r != 0; r /= 10)
//            m *= r % 10;
//
//        return persistence(m) + 1;
    }

    static int stray(int[] numbers) {
        Arrays.sort(numbers);
        if(numbers[0] == numbers[1]) return numbers[numbers.length-1];
        else return numbers[0];
    }

    public static int[] twoSum(int[] numbers, int target)
    {
        for(int i = 0; i < numbers.length; i++){

            for(int j = i+1; j < numbers.length; j++ ){
                if(numbers[i]+numbers[j] == target) return new int[] {numbers[i], numbers[j]};
            }
        }
        return null; // Do your magic!
    }

    public static int longestPalindrome(final String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                StringBuilder sb = new StringBuilder(s.subSequence(i, j));
                if (sb.length() <= result) break;
                if (sb.toString().equals(sb.reverse().toString())) {
                    result = sb.length();
                    break;
                }
            }
        }
        return result;
    }

    public static boolean check(String sentence){
        //code
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        sentence = sentence.toLowerCase();
        for (int i = 0; i < alphabet.length; i++){
            if(!sentence.contains("" + alphabet[i])) return false;
        }
        return true;

//        return sentence.chars()
//                .filter(Character::isLetter)
//                .map(Character::toLowerCase)
//                .distinct()
//                .count() == 26;
    }

    public static int minimumNumber(int[] numbers)
    {
        int sum = 0;
        for (int el: numbers) {
            sum = sum + el;
        }

        int newSum = sum;

        while(true){
            if(isPrime(newSum)) return newSum - sum;
            else newSum++;
        }
    }

    private static boolean isPrime(int newSum) {
        for(int i = 2; i < newSum/2; i++ ){
            //121
            if (newSum % i == 0) return false;
        }
        return true;
    }

    public static String[] solution(String s) {
        String[] strArray = new String[(s.length()+1)/2];

        for(int i = 0 , j = 0 ; i < strArray.length ; i++ , j = j+2){
            if(j+1 < s.length()){
                strArray[i] = s.substring(j, j+2);
            }
            else {
                strArray[i] = s.substring(s.length()-1, s.length()) + "_";
            }
        }
        return  strArray;
    }

    public static String removeParentheses(final String str) {
        // "(" first and ")"last
        // hello example (words(more words) here) something
        int firstInd = str.indexOf("(");
        int lastInd = str.lastIndexOf(")");
        String str2 = str.substring(0,firstInd);
        String str3 = str.substring(lastInd+1, str.length());
        String str4 = str2 + str3;
        return str4; // your code here
    }
}

