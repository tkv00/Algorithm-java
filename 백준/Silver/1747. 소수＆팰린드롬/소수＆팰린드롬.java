import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static int N;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        while (true){
            if (!isPrime(N))
                if (isSymmetry(N)) {
                    System.out.println(N);
                    exit(0);
                }
            N++;
        }
    }

    //소수판별
    public  static boolean isPrime(int v){
        boolean []num=new boolean[100000001];

        //소수먄 false로 바꾸자
        num[0]=true;num[1]=true;
        for(int i=2;i*i<=100000001;i++){
            //소수의 배수들
            if(!num[i]){
                for(int j=i*i;j<100000001;j+=i){
                    num[j]=true;
                }
            }
        }
        for(int i=v;;i++){
            if(!num[i] && isSymmetry(i)){
                System.out.println(i);
                exit(0);
            }
        }


    }
    //죄우 대칭?판단
    public static boolean isSymmetry(int v){
         String st= String.valueOf(v);
         char []array=st.toCharArray();
         int []num=new int[array.length];
         
         for(int i=0;i<array.length;i++){
             num[i]=Integer.parseInt(String.valueOf(array[i]));
         }
        for(int i=0;i<num.length;i++){
            if(array[i]!=array[num.length-i-1]){
                return false;
            }
        }
        return true;
    }
}
