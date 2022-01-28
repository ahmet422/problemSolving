package recursion;

public class Recursion {
    public static void main(String[] args) {
        //System.out.println("Hey");
        //prinNos(11);
        //int k = sumOfDigits(23114);
        //int k = countDigits(2344);
        int k = digitalRoot(96);
        System.out.println(k);
    }

    private static void prinNos(int N){
        if(N == 0) return;
        prinNos(N-1);
        System.out.print(N + " ");
    }

    public static int sumOfDigits(int n)
    {
       return (n == 0) ? n : n%10 + sumOfDigits(n / 10);
    }

    public static int countDigits(int n)
    {
        return (n == 0 ) ? n : countDigits(n/10) + 1;
    }

    public static int digitalRoot(int n)
    {
        if(n/10 == 0){
            return n;
        }else{
            n = n%10 + digitalRoot(n/10);
        }
        return digitalRoot(n);
      //  return (n - 1) % 9 + 1;
    }
}
