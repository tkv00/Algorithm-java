import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static long A, B;
    public static Queue<Long> prime = new LinkedList<Long>();
    public static int res = 0;
    public static boolean [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr=new boolean[(int) Math.sqrt(B)+1];
        isPrime((int)Math.sqrt(B));
        //System.out.println(Arrays.toString(arr));
        // 소수들 중 제곱해도 범위 안에 들어가는 수 모음.
        for (long i = 2; i * i <= B; i++) {
            if (!arr[(int) i]) {
                prime.add(i);
            }
        }


        while (!prime.isEmpty()) {
            long v = prime.poll();
            long max= (long) (Math.log(B)/Math.log(v));

            for(int i=2;i<=max;i++){
                long almost=(long) (Math.pow(v,i));
                if(almost>=A && almost<=B){
                    res++;
                }
                if(almost>B) break;
            }
        }

        System.out.println(res);
    }

    public static void isPrime(int v) {
        arr[0]=true;
        arr[1]=true;

        for (int i = 2; i*i <=v; i++) {
            if(!arr[i]){
                for(int j = i*i; j<=v; j+= i){
                    arr[j]=true;
                }
            }
        }
    }
}