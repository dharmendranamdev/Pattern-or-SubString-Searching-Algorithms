import java.util.*;
import java.lang.*;
public class BruteForce {
    
    static int bruteForceApproach(String text, int m, String pattern,int n)
    {
        for(int i = 0; i < m - n; i++)
        {
            int j;
            for(j = 0; j < n;j++){
                if(text.charAt(i+j) != pattern.charAt(j))
                   break;
            }
            if(j == n)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        
        String text = "abcbcbcglxd";
        String pattern = "bcgl";
        int m = text.length();
        int n = pattern.length();
        int index = bruteForceApproach(text, m, pattern,n);
        if(index != -1)
            System.out.println("Pattern Find at index : "+index);
        else
            System.out.println("Pattern not found..");
    }
}
