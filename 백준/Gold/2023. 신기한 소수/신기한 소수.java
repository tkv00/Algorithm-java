import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int N;
    public static List<Integer> res;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        for(int i=2;i<6;i++){
            if(i==2){
                dfs(i,1);
            }
            else{
                dfs(i*2-3,1);
            }
        }
    }
    static boolean checkIsPrimeNum(int num){
        for(int i=2;i<num/2;i++){
            if(num%i==0) return false;
        }
        return true;

    }
    static void dfs(int v,int depth){
        if(!checkIsPrimeNum(v)){
            return;
        }
        if(depth==N){
            System.out.println(v);
        }

        for(int i=0;i<5;i++){
            int num=2*i+1;
            int newNum= v*10+num;
            
            dfs(newNum,depth+1);
        }
    }
}
