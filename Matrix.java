/**
* A Matrix Class, Notation Used is same that is usually used in Linear Algebra
*
* @author Pr0metheus 
* @version 26.12.2019
*/
public class Matrix
{
    //Variables
    private int[][] array;// m by n matrix/array
    final int black = 255;
    final int zero = 0;
    final byte maxCount = 9;
    
    //Create the transpose of the matrix 
    private int[][] transposeA(int[][] A) 
    {
        for (int i = 0; i < array.length; i++)
        {
           for (int j = 0; j < array[0].length; j++)
           {
                A[j][i] = array[i][j];
           }
        }
        return A;
    }
    
    //Reverse The Columns 
    private int[][] reverseColumns(int[][] matrix){
        for(int col = 0;col < matrix[0].length; col++)
        {
            for(int row = 0; row < matrix.length/2; row++) 
            {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[matrix.length - row - 1][col];
                matrix[matrix.length - row - 1][col] = temp;
            }
        }
        
        return matrix;
    }
    
    //Reverse the Rows
    private int[][] reverseRows(int[][] matrix)
    {
    for(int row = 0; row < matrix.length; row++)
    {
        for(int col = 0; col < matrix[row].length / 2; col++) 
        {
            int temp = matrix[row][col];
            matrix[row][col] = matrix[row][matrix[row].length - col - 1];
            matrix[row][matrix[row].length - col - 1] = temp;
        }
    }
    return matrix;
    }    
        
    //Calculate neighbours average of given item in matrix (Including the item itself) 
    private int calcNeigh(int I, int J)
    {
        int count = 0;
        int total = 0;
        
        for(int i = 0; i < array.length; i++)
        {
           for(int j = 0; j < array[0].length; j++)
           {
                if (Math.abs(I - i) <= 1 && 1 >= Math.abs(J - j))
                {
                    total += array[i][j];
                    count++;
                }
           }
        }
        return total/count;
    }
    
    /**
    * Initialize an instance of a Matrix with the given array Object
    */
    //Constructor that creates a matrix from a 2-dimensional array (The matrix will have the same dimensions as the array)
    public Matrix(int[][] array) 
    {
       // m,n rows,columns (Same notation used in Linear Algebra)
       int m = array.length;
       int n = array[0].length;
       this.array = new int[m][n];
       for(int i = 0; i < m; i++)
       {
           for(int j = 0; j < n; j++)
           {
               this.array[i][j] = array[i][j];
           }
       }
    }
    
    /**
    * Initialize an instance of a null Matrix with the given m,n
    * @param size1 m/number of rows in matrix
    * @param size2 n/number of columns in matrix
    */
    //Creates a size1 (m) by size2 (n) matrix of zeroes 
    public Matrix(int size1, int size2)
    {
        this.array = new int[size1][size2];
        
        for(int i = 0; i < size1; i++)
        {
            for(int j = 0; j < size2; j++)
            {
                this.array[i][j] = 0;
            }
        }
    }
    
    /**
    * Return a Matrix toString of the from [a11,a12]
    *                                      [a21 a22] etc...
    * @return String text 
    */
    //toString of Matrix 
    public String toString()
    {
        String text = "";
        
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                text = text + array[i][j] + "\t";
            }
            
            text = text + "\n";
        }
        
        return text;
    }
    
    /**
    * Create a new negative matrix from matrix on which method was used
    * @return "negative" matrix 
    */
    //Return "negative" matrix 
    public Matrix makeNegative() 
    {
        int[][] negArray = new int[array.length][array[0].length];
        
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                negArray[i][j] = 255-array[i][j];
            }
        }
        
        return new Matrix(negArray);
    }
    
     /**
    * Create a new "image filter" matrix from matrix on which method was used
    * @return "image filter" matrix 
    */
    //return imagefilter matrix 
    public Matrix imageFilterAverage()
    {
        int [][] fillArray = new int [array.length][array[0].length];
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array[0].length; j++)
            {
                fillArray[i][j] = (int) calcNeigh(i,j);
            }
        }
        
        return new Matrix(fillArray);
    }
    
    //rotate matrix clockwise 
     /**
    * Create a new Rotated matrix (Clockwise) from matrix on which method was used. The matrix is created by using the transpose of the matrix 
    * and then reversing each row
    * @return rotated matrix 
    */
    //rotate matrix clockwise using transpose --> reverseRows
    public Matrix rotateClockwise()
    {
        int[][] RotCArray = new int[array[0].length][array.length];
        return new Matrix(reverseRows(transposeA(RotCArray))); 
    }
    
    
     /**
    * Create a new Rotated matrix (CounterClockwise) from matrix on which method was used. The matrix is created by using the transpose of the matrix 
    * and then reversing each column
    * @return rotated matrix 
    */
    //rotate matrix counterclockwise using transpose --> reverseColumns 
    public Matrix rotateCounterClockwise()
    {
        int[][] RotCArray = new int[array[0].length][array.length];
        return new Matrix (reverseColumns(transposeA(RotCArray))); 
    }

}


