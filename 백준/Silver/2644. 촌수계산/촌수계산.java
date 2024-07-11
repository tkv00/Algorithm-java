import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int totalPeople;
    public static int start;
    public static int end;
    public static int relationShip;
    public static StringTokenizer st;
    public static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        totalPeople=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        start= Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());
        relationShip=Integer.parseInt(br.readLine());

        arr=new ArrayList[totalPeople+1];
        for(int i=0;i<=totalPeople;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<relationShip;i++){
            st=new StringTokenizer(br.readLine());
            int one=Integer.parseInt(st.nextToken());
            int two=Integer.parseInt(st.nextToken());
            arr[one].add(two);
            arr[two].add(one);

        }

        int []count=new int[totalPeople+1];
        Arrays.fill(count,-1);
        int cnt=0;
        boolean[] visited=new boolean[totalPeople+1];
        Queue <Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        count[start]=0;

        while(!queue.isEmpty()){
            int v=queue.poll();
            for(int index:arr[v]){
                if(!visited[index]){
                    visited[index]=true;
                    count[index]=count[v]+1;
                    queue.add(index);
                }
            }
        }
        System.out.println(count[end]);

    }


}
