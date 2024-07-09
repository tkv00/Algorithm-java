import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Main {
    public static class Point {
        long x;
        long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Line {
        Point p1;
        Point p2;

        Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Line[] lines = new Line[2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);
            lines[i] = new Line(p1, p2);
        }
        //일반적인 교차
        if (CCW(lines[0].p1, lines[0].p2, lines[1].p1) * CCW(lines[0].p1, lines[0].p2, lines[1].p2) < 0
                && (CCW(lines[1].p1, lines[1].p2, lines[0].p1) * CCW(lines[1].p1, lines[1].p2, lines[0].p2) < 0)
        ) {
            System.out.println(1);
            exit(0);
        }
        System.out.println(0);
    }

    public static int CCW(Point p1,Point p2,Point p3){
        long res=p1.x*(p2.y-p3.y)-p1.y*(p2.x-p3.x)+p2.x*p3.y-p3.x*p2.y;
        //일직선인 경우
        if(res==0)return 0;
        //반시계인 경우
        else if(res>0) return 1;
        //시계인 경우
        else return -1;
    }


}
