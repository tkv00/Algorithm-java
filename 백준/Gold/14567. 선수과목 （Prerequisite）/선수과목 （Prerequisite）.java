import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static int[] indgree;
    private static int[] result;
    private static ArrayDeque<Integer> dq=new ArrayDeque<>();
    private static HashMap<Integer, ArrayList<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        indgree=new int[N+1];
        result=new int[N+1];
        map=new HashMap<>();

        for (int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            ArrayList<Integer> arrayList=map.getOrDefault(start,new ArrayList<>());
            arrayList.add(end);
            map.put(start,arrayList);

            indgree[end]+=1;
        }
        for (int i=1;i<=N;i++){
            if(indgree[i]==0){
                result[i]=1;
                dq.addLast(i);
            }
        }
     

        while (!dq.isEmpty()){
            int num=dq.pollFirst();
            ArrayList<Integer> arr=map.get(num);
            if (arr==null) continue;
            for (int i=0;i<arr.size();i++){
                int x=arr.get(i);
                indgree[x]--;
                if(indgree[x]==0){
                    dq.addLast(x);
                    result[x]=result[num]+1;
                }
            }
        }



        for (int i=1;i<=N;i++){
            System.out.print(result[i]+" ");
        }
    }
}
