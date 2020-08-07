/**
 * Maman 11 Q1
 *
 * @author Pr0metheus 
 * @version 24.11.2019
 * Program finds Perimeter and area of triangle (using Heron's formula)   
 */
import java.util.Scanner;

public class Triangle
{
    //Checks if sides are valid in set of Real numbers
   private static boolean validSides(int a, int b, int c) 
{ 
    // check if sides are valid using Triangle inequality
    if (a + b <= c || a + c <= b || b + c <= a) 
        return false; 
        
    else
        return true; 
        
}
   //Method to Calculate Perimeter
   private static double calcPerim(int a, int b, int c)
   {
       return a+b+c;
    }
   
   //Method to calculate area using Heron's Formula 
   private static double heron(int a, int b, int c, double perim)
   {
       return Math.sqrt(perim*(perim-a)*(perim-b)*(perim-c));
    }
 
 public static void main (String [] args)
 {
 //Get triangle sides from user input 
 Scanner scan = new Scanner (System.in);
 System.out.println ("This program calculates the area "
 + "and the perimeter of a given triangle. ");
 System.out.println ("Please enter the three lengths"
 + " of the triangle's sides");
 int a = scan.nextInt();
 int b = scan.nextInt();
 int c = scan.nextInt(); //Continue 
 //Check if sides are valid 
 if (validSides(a,b,c) == false)
    {
        System.out.println("Error101: Not triangle sides in R"); //If not return an error 
        System.out.println("a: " + a + " b: " + b + " c: " + c);
    }
 //If triangle sides are valid,continue   
 else
 {
     //Print triangle info using private methods written above 
     System.out.println("Valid Input");
     System.out.println("Perimeter: " + calcPerim(a,b,c)); 
     //Divide by two to get semi-perimeter for use in Heron's formula  
     System.out.println("Area:" + heron(a,b,c,calcPerim(a,b,c)/2)); 
 }
 
 } // end of method main
} //end of class Triangle 