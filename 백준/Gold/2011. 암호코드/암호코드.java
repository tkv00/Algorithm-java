import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;

import static java.lang.System.exit;

public class Main {
    static long[] arr;
    static boolean res = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] input = str.toCharArray();
        int size = input.length;
        arr = new long[5001];
        //0앞에 아무것도 오지않는 경우
        if (input[0] == '0') {
            res = false;
            System.out.println(0);
            exit(0);
        }
        arr[0] = 1;
        if(input.length==1){
            System.out.println(1);
            exit(0);
        }
         if(input[1]=='0'&&change(input[1])+change(input[0])*10>26){
            res=false;
        }
        if (change(input[1]) != 0 && change(input[0]) * 10 + change(input[1]) >= 10 && change(input[0]) * 10 + change(input[1]) <= 26) {
            arr[1] = 2;
        } else {
            arr[1] = 1;
        }

        for (int i = 2; i < size; i++) {
            int prev = change(input[i - 1]);
            int now = change(input[i]);
            int k = prev * 10 + Integer.parseInt(String.valueOf(input[i]));

            //예외처리
            if (now == 0 && prev == 0) {
                res = false;
            } else if (now == 0 && prev >= 3) {
                res = false;
            }

            if (change(input[i]) != 0 && k > 10 && k <= 26) {
                arr[i] = arr[i - 1] % 1000000 + arr[i - 2] % 1000000;
            } else if (input[i] == '0' && k <= 26) {
                arr[i] = arr[i - 2];
            } else {
                arr[i] = arr[i - 1] % 1000000;
            }
            arr[i]%=1000000;

        }
        if (!res) {
            System.out.println(0);

        } else {
            System.out.println(arr[size - 1]);
            //System.out.println(Arrays.toString(arr));
            //System.out.println(Arrays.toString(arr));
        }

    }

    static int change(char k) {
        return Integer.parseInt(String.valueOf(k));
    }
}
