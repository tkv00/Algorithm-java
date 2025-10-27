import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static boolean isPrime(int num){
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i==0) return false;
        }
        return true;
    }

    private static int N;
    private static BufferedReader br;
    private static List<Integer> primes;

    private static void init() throws IOException {
        br=new BufferedReader(new InputStreamReader(System.in));
        primes=new ArrayList<>();
        N=Integer.parseInt(br.readLine());

        for (int i=2;i<=N;i++){
            if(isPrime(i)) primes.add(i);
        }
    }

    private static int operation(int num){
        int start=0;
        int end=0;
        int cnt=0;
        int sum=0;

        while (true){
            if (num<=sum){
                sum-=primes.get(start); start++;
            }
            else if (end==primes.size()){
                break;
            }
            else if (sum<num){
                sum+=primes.get(end); end++;
            }

            if (sum==num) cnt++;
        }

        return cnt;
    }
    //구간합
    private static int subSum(int start,int end){
        int sum=0;
        for (int i=start;i<=end;i++){
            sum+=primes.get(i);
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(operation(N));;
    }
}
