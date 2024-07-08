import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
   static class Point{
        int x;int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int vector(){
       Point p3=points.pop();
       Point p2=points.pop();
       Point p1=points.pop();
       Point p1p2=new Point(p2.x-p1.x,p2.y-p1.y);
       Point p2p3=new Point(p3.x-p2.x,p3.y-p2.y);
        Point p3p1=new Point(p1.x-p3.x,p1.y-p3.y);

        double S=p1p2.x*(p2p3.y-p3p1.y)-p1p2.y*(p2p3.x-p3p1.x)+p2p3.x*p3p1.y-p3p1.x*p2p3.y;
       if(S>0)return 1;
       else if(S<0) return -1;
       else return 0;
    }
    public static boolean a(int x,int y){
       if((x>0 && y>0) || (x<0 && y<0)) return true;
       else  return false;
    }
    static Stack<Point> points;
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        points=new Stack<>();
        for(int i=0;i<3;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            points.push(new Point(x,y));
        }
        System.out.println(vector());

    }

}
