import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static class Point {
        int start;
        int end;

        Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class PointComparator implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            //끝나는 시간이 빠른게 우선순위
            return o1.start - o2.start;
        }
    }

    public static int N;
    public static StringTokenizer st;
    public static int sum=0;

    public static void main(String[] args) throws IOException {
        PriorityQueue<Point> pq = new PriorityQueue<>(1, new PointComparator());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            pq.offer(new Point(start,end));
        }

        if(pq.size()<=1){
            System.out.println(1);
            exit(0);
        }
        res(pq);



    }
    public static void res(PriorityQueue<Point> pq){
        if(pq.isEmpty())return;

        int[] arr=new int[200001];
        int idx=0;

        Point p=pq.poll();
       int firstStart=p.start;
       int firstEnd=p.end;
       arr[idx]=firstEnd;
       idx++;

        while (!pq.isEmpty()){
            if(idx >= 200001) {
                System.out.println(200001);
                return;
            }
            Point now=pq.poll();

            int start=now.start;
            int end=now.end;
            boolean isSelected=false;
            for(int i=0;i<idx;i++){
                if(arr[i]<=start){
                    arr[i]=end;
                    isSelected=true;
                    break;
                }
            }
            if(!isSelected){
                arr[idx]=end;
                idx++;
            }
        }
        System.out.println(idx);
    }
}
