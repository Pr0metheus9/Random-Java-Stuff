/**
 * Maman 11 Q2
 *
 * @author Pr0metheus 
 * @version 27.11.2019
 * The Program checks if two triangles are Congruent (in Euclidean space)
 */
import java.util.Scanner;

public class Congruent
{
    //Method that allows us to output in the format (x,y)
    private static String point(double x, double y)
    {
        return "("+x+", "+y+")";
    }
    
    //Method to calculate triangle side using two points/distance between two points  
    private static double calcSide(double x1,double y1,double x2,double y2)
    {
        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    }
    
    //Method to check if two given triangles are congruent 
    private static boolean checkCong(double a,double alpha, double b, double beta, double c, double gamma)
    {
        //Check if they are congruent using Side-Side-Side
        //3! Possible Combinations and thus using else if is fine (Not too long)-The number of permutations of 3 distinct objects is 6 
        if(a==alpha && b == beta && c == gamma || a == alpha && b == gamma && c == beta)
        {
            System.out.print("The triangles are congruent");
            return true;
        }
        
        else if(a==beta && b == alpha && c == gamma || a == beta && b == gamma && c == alpha)
        {
            System.out.print("The triangles are congruent");
            return true;
        }
        
        else if(a==gamma && b == beta && c == alpha || a == gamma && b == alpha && c == beta)
        {
            System.out.print("The triangles are congruent.");
            return true;
        }
        
        else
        {
            System.out.print("The triangles are not congruent.");
            return false;
        }
    }
        
        
    public static void main(String args[])
    {
        //Similar to matrix representation 
        double x11,x12,x13,x21,x22,x23,y11,y12,y13,y21,y22,y23; //Points on plane, xkn,ykn = n point on k triangle
        double a1,b1,c1,a2,b2,c2; //Triangle sides (a,b,c sides of triangle 1), (a2,b2,c2 side of triangle 2) 
        boolean acongruent; //Boolean to store return value of checkCong(if they are congruent store true, else store false)
        Scanner scan = new Scanner(System.in); //Scanner object 
        
        //ask input for every point's x and y coordinates 
        System.out.println("Enter Points for first triangle in Euclidean space. input: 1. x11 2. y11 3. x12 4.y12...etc");
        x11 = scan.nextDouble();
        y11 = scan.nextDouble();
        x12 = scan.nextDouble();
        y12 = scan.nextDouble();
        x13 = scan.nextDouble();
        y13 = scan.nextDouble();
        a1 = calcSide(x11,y11,x12,y12); 
        b1 = calcSide(x11,y11,x13,y13); 
        c1 = calcSide(x12,y12,x13,y13); 
        x21 = scan.nextDouble();
        y21 = scan.nextDouble();
        x22 = scan.nextDouble();
        y22 = scan.nextDouble();
        x23 = scan.nextDouble();
        y23 = scan.nextDouble();
        a2 = calcSide(x21,y21,x22,y22); 
        b2 = calcSide(x21,y21,x23,y23); 
        c2 = calcSide(x22,y22,x23,y23);
        System.out.println("The first triangle is " + point(x11,y11) + " " + point(x12,y12) + " " + point(x13,y13) + ".");
        System.out.println("Its lengths are " + a1 + ", " + b1 + ", " + c1 + ".");
        System.out.println("The second triangle is " + point(x21,y21) + " " + point(x22,y22) + " " + point(x23,y23) + ".");
        System.out.println("Its lengths are " + a2 + ", " + b2 + ", " + c2 + ".");
        System.out.println("");
        acongruent = checkCong(a1,a2,b1,b2,c1,c2);
    }
}
