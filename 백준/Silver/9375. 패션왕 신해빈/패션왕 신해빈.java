import java.util.*;
import java.io.*;
public class Main {
    private static int T;
    private static int N;
    private static HashMap<String,ArrayList<String>> map;
    private static int factorial(int n){
        if(n==1) return n;
        return factorial(n-1)*n;
    }
    private static int combination(int n,int k){
        return factorial(n)/(factorial(n-k)*factorial(k));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<T;i++){
            N=Integer.parseInt(br.readLine());
            map=new HashMap<>();
            int result=1;
            for(int j=0;j<N;j++){
                String str=br.readLine();
                String[] list=str.split(" ");
                map.putIfAbsent(list[1],new ArrayList<>());
                map.get(list[1]).add(list[0]);
            }
            for(String key:map.keySet()){
                result*=map.get(key).size()+1;
            }
            sb.append(result-1).append("\n");
        }
        
        System.out.print(sb);
    }
}
