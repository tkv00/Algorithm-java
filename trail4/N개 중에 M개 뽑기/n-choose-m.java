import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();           

        // Please write your code here.
        sb = new StringBuilder();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        dfs(0,0,m,new int[m],arr);

        System.out.print(sb.toString());
    }
    static StringBuilder sb;
    static void dfs(int idx,int cnt,int m,int[] arr,int[] inputs){
        if(cnt>m) return;
        if(cnt==m){
            for(int a:arr){
                sb.append(a).append(" ");
            }

            sb.append("\n");
            return;
        }

        for(int i=idx;i<inputs.length;i++){
            arr[cnt]=inputs[i];
            dfs(i+1,cnt+1,m,arr,inputs);
        }
    }
}