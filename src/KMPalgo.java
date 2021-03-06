
public class KMPalgo {
    public static void KMP(String text, int m, String pattern, int n)
    {
        //int pi_table[] = new int[n];//length of pattern String 
        //createPrefix(pattern, n, pi_table);
        int k = 0;
        for(int i = 0; i < m; i++)
        {
            while( k > 0 && pattern.charAt(k) != text.charAt(i))
               k--;
            if(pattern.charAt(k) == text.charAt(i))
               k += 1;
            if(k == n)
            {
               //return (i + 1) - m;
               System.out.println("Pattern Fount at index :"+((i+1)-n));
               k = 0;
            }
        }
        
    }
    
    public static void main(String[] args) {
        String text = "abedabcabc";
        String pattern = "abc";
        int m = text.length();
        int n = pattern.length();
        KMP(text, m, pattern,n);
        /*
        if(index != -1)
            System.out.println("Pattern Find at index : "+index);
        else
            System.out.println("Pattern not found..");
        */
    }
}
