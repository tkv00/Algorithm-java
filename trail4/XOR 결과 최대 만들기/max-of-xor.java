import java.util.*;

public class Main {
    static int max;
    static boolean[] visited;
    static void dfs(int cnt,int idx,int cal,int m,int[] arr){
        if(cnt==m){
            max = Math.max(cal,max);

            return;
        }

        for(int i=idx+1;i<arr.length;i++){
            dfs(cnt+1,i,arr[i] ^ cal,m,arr);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        // Please write your code here.

        if(A.length==1) {
            System.out.print(A[0]);
            return;
        }

        max=-1;
        for(int i=0;i<A.length;i++){
            dfs(1,i,A[i],m,A);
        }
        

        System.out.print(max);
    }
}