import java.util.*;
import java.lang.*;
public class RabinKarpAlgo {
    static int prime = 3;//anything you want
    static int valofchar(String str, int index)
    {
        //return str.charAt(index);////for ASCII Value a= 97,b = 98....
        return str.charAt(index) - 'a' + 1;// a = 1, b == 1, c = 3..etc
    }
    static int calReHash(String text, int lenofPattern, int oldCharIndex, int newcharIndex, int oldhash)
    {
        //System.out.println("text : "+text+" lenofPattern :"+lenofPattern+" oldIndex " + oldCharIndex+ " newIndex"+newcharIndex + " oldhash "+oldhash);
        int x = oldhash - valofchar(text, oldCharIndex);
        x = x / prime;
        int newHash = x + (int)Math.pow(prime, lenofPattern - 1) * valofchar(text, newcharIndex);
        return newHash;
    }
    static int calHash(String str, int len)
    {
        int sum = 0;
        for(int i = 0; i < len; i++)
        {
            sum = sum + valofchar(str, i) * (int)Math.pow(prime, i);
            //System.out.println(str + " val of char : " + valofchar(str, i));
        }
        return sum;
    }
    static int RabinKarp(String text, int m, String pattern, int n)
    {
        int patternHash = calHash(pattern, n);
        int firstHashofText = calHash(text, n);
        //System.out.println("pattern Hash : "+patternHash);
        //System.out.println("firstHash : "+firstHashofText);
        if(firstHashofText == patternHash)
            return 0;
        int oldhash = firstHashofText;
        for(int i = 1; i <= m - n; i++)
        {
            int newHash = calReHash(text, n, i - 1, i + n - 1,oldhash);
            //System.out.println("newHash : i  " + newHash + " " + i);
            if(newHash == patternHash)
                return i;
            oldhash = newHash;
        }
        return -1;
    }
    public static void main(String[] args) {
        String text = "abedabc";
        String pattern = "abc";
        int m = text.length();
        int n = pattern.length();
        int index = RabinKarp(text, m, pattern,n);
        if(index != -1)
            System.out.println("Pattern Find at index : "+index);
        else
            System.out.println("Pattern not found..");
    }
}
