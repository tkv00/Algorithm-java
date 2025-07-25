import java.io.*;
import java.util.*;
public class Main {
    private static class Egg{
        int durability;
        int weight;

        Egg(int durability,int weight){
            this.durability=durability;
            this.weight=weight;
        }
    }
    private static void hitEgg(int leftIdx,int rightIdx){
        int leftWei=list[leftIdx].weight;
        int rightWei=list[rightIdx].weight;

        list[leftIdx].durability-=rightWei;
        list[rightIdx].durability-=leftWei;
    }

    private static void removeEgg(int leftIdx,int rightIdx){
        int leftWei=list[leftIdx].weight;
        int rightWei=list[rightIdx].weight;

        list[leftIdx].durability+=rightWei;
        list[rightIdx].durability+=leftWei;
    }

    private static void DFS(int idx,int cnt){
        if(idx==N){
            result=Math.max(cnt,result);
            return;
        }

        //모든 계란이 깨지거나 손에 든 계란이 깨진 경우
        if(list[idx].durability<=0){
            DFS(idx+1,cnt);
            return;
        }

        boolean canHit=false;

        for(int i=0;i<N;i++){
            if(i==idx) continue;
            if(list[i].durability<=0) continue;

            boolean leftBroken=list[idx].durability<=0;
            boolean rightBroken=list[i].durability<=0;

            canHit=true;
            //계란 부딪히기
            hitEgg(idx,i);
            int broken=0;
            //왼쪽이 깨지는 경우
            if(!leftBroken && list[idx].durability<=0){
                broken++;
            }
            //오른쪽이 깨지는 경우
            if(!rightBroken && list[i].durability<=0){
                broken++;
            }
            DFS(idx+1,cnt+broken);

            //원상 복구
            removeEgg(idx,i);
        }
        if(!canHit){
            DFS(idx+1,cnt);
        }
    }
    private static int N;
    private static StringTokenizer st;
    private static int result=0;
    private static Egg[] list;
    private static boolean[] breakEgg;
    public static void main(String[] args) throws IOException {
        //계란 - 내구도/무게
        /*ex) 계란1 내구도 7, 무게 5
              계란2 내구도 3, 무게 4
              계란치기 -> 계란1 내구도 7-4=3 계란2 내구도 3-5=-2
        * */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        list=new Egg[N];
        breakEgg=new boolean[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int durability=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            list[i]=new Egg(durability,weight);
        }
        DFS(0,0);
        System.out.print(result);
    }

}
