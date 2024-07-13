import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        String[] s=sc.nextLine().split("");
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
