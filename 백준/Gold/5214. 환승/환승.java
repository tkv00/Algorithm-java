import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    static int N;
    static int K;
    static int M;
    static StringTokenizer st;
    static ArrayList<Integer>[] arrayLists;
    static boolean[]visit;
    static Queue<Point> queue=new LinkedList<>();
    static class Point{
        int num;
        int sum;
        Point(int num,int sum){
            this.num=num;
            this.sum=sum;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arrayLists=new ArrayList[N+M+1];
        for(int i=0;i<=N+M;i++){
            arrayLists[i]=new ArrayList<>();
        }

        visit=new boolean[N+1+M];

        for(int i=1;i<=M;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=K;j++){
                int t=Integer.parseInt(st.nextToken());
                arrayLists[t].add(N+i);
                arrayLists[N+i].add(t);
            }
        }
        queue.add(new Point(1,1));
        if(N==1){
            System.out.println(1);
            exit(0);
        }
        visit[1]=true;
        while (!queue.isEmpty()){
            Point now=queue.poll();
            for(int c:arrayLists[now.num]){
                if(!visit[c]){
                    if(c==N){
                        System.out.println(now.sum+1);
                        exit(0);
                    }
                    int cnt=c>N? now.sum : now.sum+1;
                    visit[c]=true;
                    queue.add(new Point(c,cnt));
                }
            }
        }
        System.out.println(-1);
    }
}
