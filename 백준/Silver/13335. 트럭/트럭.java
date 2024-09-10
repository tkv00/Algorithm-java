import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> queue=new LinkedList<>();
    static Queue<Integer> bridge=new LinkedList<>();
    static int n;
    static int w;
    static int L;
    static StringTokenizer st;
    static int time=0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        arr=new int[L];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }
        for (int i=0;i<L;i++){
            bridge.add(0);
        }
        int k=0;
        while (!bridge.isEmpty()){
            time+=1;
            k-=bridge.poll();
            if(!queue.isEmpty()){
                //무게 초과x
                if(k+queue.peek()<=w){
                    int truck=queue.poll();
                    bridge.add(truck);
                    k+=truck;
                }else{
                    bridge.add(0);
                }

            }
        }
        System.out.println(time);

    }

}
