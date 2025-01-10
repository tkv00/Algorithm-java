import java.util.*;

public class Solution {
    public int solution(int n) {
        String binary=Integer.toBinaryString(n).replace("0","");
        return binary.length();
    }
}