import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int cnt;
    private static final int SIZE=10000;
    private static boolean[] prime=new boolean[SIZE];
    private static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
    private static int bfs(int num1,int num2){
        boolean[] visited=new boolean[SIZE];
        visited[num1]=true;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.addLast(new int[]{num1,0});

        while(!q.isEmpty()){
            int[] now=q.pollFirst();
            if(now[0]==num2) return now[1];

            char[] numToArray=String.valueOf(now[0]).toCharArray();
            for(int i=0;i<4;i++){
                for(char c='0';c<='9';c++){
                    //앞자리 0제외
                    if(i==0 && c=='0') continue;
                    char original=numToArray[i];
                    numToArray[i]=c;
                    int next=Integer.parseInt(String.valueOf(numToArray));
                    if(!visited[next]&&prime[next]){
                        visited[next]=true;
                        q.addLast(new int[]{next,now[1]+1});
                    }
                    numToArray[i]=original;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int K=Integer.parseInt(br.readLine());

        for(int i=1000;i<SIZE;i++){
            if(isPrime(i))
                prime[i]=true;
        }

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            cnt=bfs(num1,num2);
            if(cnt==-1){
                sb.append("Impossible").append("\n");
                break;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
