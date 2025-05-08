import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static void union(int a,int b){
        a=findParent(a);
        b=findParent(b);
        if(a<b)arr[b]=a;
        else arr[a]=b;
    }
    private static int findParent(int a){
        if(arr[a]==a)
            return a;
        return arr[a]=findParent(arr[a]);
    }
    private static boolean isUnion(int a,int b){
        a=findParent(a);
        b=findParent(b);
        if(a==b)
            return true;
        return false;
    }
    private static int N;
    private static int[] arr;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=i;
        }

        for(int i=0;i<N-2;i++){
            st=new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            union(num1,num2);
        }

        for(int i=2;i<=N;i++){
            if(!isUnion(1,i)){
                System.out.println(1+" "+i);
                break;
            }

        }
    }
}
