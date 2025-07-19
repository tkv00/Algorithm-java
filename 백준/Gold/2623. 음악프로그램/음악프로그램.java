import java.io.*;
import java.util.*;
public class Main {
    private static int N,M;
    private static StringTokenizer st;
    private static int[] indegree;
    private static Queue<Integer> q=new LinkedList<>();
    private static HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        indegree=new int[N+1];
        for(int i=1;i<=N;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            String str=br.readLine();
            String[] arr=str.split(" ");
            int size=Integer.parseInt(arr[0]);
            int[] intArr=new int[size];
            for(int j=0;j<size;j++){
                intArr[j]=Integer.parseInt(arr[j+1]);
            }
            for(int j=0;j<size-1;j++){
                map.get(intArr[j]).add(intArr[j+1]);
                indegree[intArr[j+1]]+=1;
            }
        }
        int count=0;

        for(int i=1;i<=N;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now=q.poll();
            sb.append(now).append("\n");
            count++;
            ArrayList<Integer> nowArr=map.get(now);
            for(int x:nowArr){
                indegree[x]--;
                if(indegree[x]==0){
                    q.offer(x);
                    //sb.append(x).append("\n");
                }
            }
        }
        if(count!=N){
            System.out.print(0);
            return;
        }
        System.out.print(sb);

    }
}
