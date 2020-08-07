/**
 * Q1: aleph worst case time complexity = O(n) - the pointer will go through whole 
 * string once. Space complexity = O(1)
 * 
 * 
 * Q1: bet time complexity = O(n) because we only go through the array of chars (string) once to calculate the number of times that the char is found in the string   
 * space complexity = O(1) - we get the string as input 
 * 
 * Q2: time complexity = O(n) because we only go through the array n order of times (once from each side)   
 * space complexity = O(1) - we get the array as input and we only change the array values (we do not create a new array) 
 * 
 * 
 * @author Prometheus 
 * @version 31.01.2020
*/

public class Ex14
{ 
    //Removes duplicates in a string 
    private static String fixedS(String s)
    {
        if ( s.length() <= 1 )
        { 
            return s;
        }
        
        if( s.substring(1,2).equals(s.substring(0,1))) 
        {
            return fixedS(s.substring(1));
        }
        else 
        {
            return s.substring(0,1) + fixedS(s.substring(1));
        }
    }
    
    /**
     * Q1: aleph
     *
     * @param  String s: some string
     * @param char c: some char 
     * @return The number of times c is in substring of s as first and last char and is found once inbetween the first and last chars
     */
    public static int subStrC(String s, char c) 
    {
        //setup
        
        int p1 = 0,p2 = 0 ,num = 0;
        
        //find first c in string and set pointer one to that char
        while(p1 < s.length() && s.charAt(p1) != c)
        {
            p1++;
        }
        
        //set pointer two to pointer plus 1 
        p2 = p1+1;
        
        while(p2 < s.length() && s.charAt(p2) != c )
        {
            p2++;
        }
        
        //main function
        
        //while second pointer is in string
        while(p2 < s.length())
        {
            /* if both pointers have value of c add to num, 
            set pointer one to pointer 2 and add 1 to pointer two in
            order to countine */
            if(s.charAt(p1) == c && s.charAt(p2) == c)
            {
                num++;
                p1 = p2; 
                p2++;
            }
            
            //Add to pointer two 
            else
            {
                p2++;
            }
        }
        
        //if char does not exist
        if(num == 0)
        {
            return 0;
        }
        
        //remove one for initial value with c
        return num-1; 
    }
    
    //Q1:bet
     /**
     * Q1: bet
     *
     * @param  String s: some string
     * @param char c: some char 
     * @param int k: some int
     * @return The number of times c is in substring of s as first and last char and is found max of k times inbetween the first and last chars
     */
    
    //using basic combinatorics we get the equation https://www.wolframalpha.com/input/?i=sum+%28n-i%29%2C+i%3D0+to+k%2B1 (for n>k)
    public static int subStrMaxC(String s, char c, int k) 
    {
        int n = 0;
        
        //find the number of times that the char is found in the string 
        for(int i=0;i<=s.length()-1;i++)
        {
            if(s.charAt(i) == c)
            {
                n++;
            }
        }
        
        //return the number of substrings using the equation above (only returning positive values)
        if(n>1)
        {
        return  (int)(-0.5*(k+1)*(k-2*n+2));
        }
        
        //if no substring exists return 0
        else
        {
            return 0;
        }
    }
    
     /**
     * Q2
     *
     * @param  int array a: array of 0 and 1 
     * @return int array with the distance of each of the values from the closest 0
     */
    
    //change values from right side and then from left, use a counter that resets everytime it finds 0 and contains the value of the distance from the closest 0 from said side
    static void zeroDistance (int a[]) 
    {
        final int MAGIC = 1000000;
        
        //value if no 0 is found
        int dis = -1;
        
        //from left(0-n) side of array, find the distance from 0
        for (int i=0 ; i<a.length ; i++) 
        {            
           if (a[i] == 0) 
           {
               dis = 0;
           }
               
           else 
           {
               if (dis == -1) 
               {
               a[i] = MAGIC;
               }
               
               else
               {
               dis++;
               a[i] = dis;
               }
           }                    
        }
        
        //reset 
        dis = -1;
        
        //find distance from right(n-0) side of array, find the distance from 0, same as left side
        for (int i=a.length-1; i>=0 ; i--) 
        {            
           if (a[i] == 0)  
           {
               dis = 0;
           }
           //Check if value from left side needs to be changed (will only occur if distance from right side is smaller)
           else if (dis != -1 && a[i] > ++dis) 
           {
               a[i] = dis; 
           }
        }
    }
    
    //Q3
    /**
     * Q3
     *
     * @param String s: some string 
     * @param String t: some string 
     * @return true if t is a transformation of s by reducing the strings to basic parts and checking to see if they are the same, else: return false
     */
    public static boolean isTrans (String s, String t)
    {
        System.out.println(fixedS(s) + "" + fixedS(t));
        //if s is larger than t then t cannot be a transformation of s because it will have less duplicates than s if at all
        if(fixedS(s).equals(fixedS(t)) && t.length() >= s.length())
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }

    ///Q4
    public static int countPaths(int[][] mat, int i, int j)
    {
        //set border of matrix, max i is number of the columns of the matrix, maxj is the number of rows in the matrix 
        int maxi = mat.length - 1;
        int maxj = mat[maxi].length - 1;
        final int TEN = 10;
        
        //if path has completed, return one/gotten to the end of the matrix 
        if (i==maxi && j==maxj)
        {
            return 1;
        }

        //if you are out of the matrix,then the path is not legal 
        if(i>maxi || j>maxj)
        {
            return 0;
        }

        //Special case where the value of a place in the matrix is 0 (you cannot continue and thus the path is invalid)
        else if(mat[i][j] == 0)
        {
            return 0;
        }
        
        //return the possible paths from digits of value [i+first digit], [j+second digit] - [i+second digit], [j+first digit]
        else
        {
            return countPaths(mat,i+mat[i][j]/TEN,j+mat[i][j]%TEN) + countPaths(mat,i+mat[i][j]%TEN,j+mat[i][j]/TEN ); 
        }
    }
    
    /**
     * Q4
     *
     * @param  int matrix mat: marix with numbers 
     * @return number of valid paths (will start from "first" element in the matrix)
     */
    public static int countPaths(int[][] mat)
    {
        return countPaths(mat,0,0);
    }
    
}
