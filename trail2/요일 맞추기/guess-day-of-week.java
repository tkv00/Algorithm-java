import java.util.*;
public class Main {
    static final int[] days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    static final String[] strDays = new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        

        int gap = 0;

        int sum1 = 0;
        int sum2 = 0;

        for(int i=0;i<m1-1;i++){
            sum1+=days[i];
        }

        sum1+=d1;

        for(int i=0;i<m2-1;i++){
            sum2+=days[i];
        }

        sum2+=d2;
        gap = sum1-sum2;

        

        if(gap>=0){
            gap %= 7;
            if(gap==0){
                System.out.print(strDays[0]);
                return;
            }
            System.out.print(strDays[7-gap]);
            return;
        }else{
            gap=Math.abs(gap)%7;
            System.out.print(strDays[gap]);
            return;
        }
    }
}