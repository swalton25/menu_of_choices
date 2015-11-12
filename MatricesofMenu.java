
/** This program provides the user with a menu of choices that have to do with performing operations on two-dimensional arrays below. 
 * The user should be allowed to request for multiple operations within a session.  
 * In other words, your main program should have a loop that calls a method menu until the user selects option 5.  
 * Author: Samuel Walton
 * Section: 102
 * 4/22/2013
 * Programming Assignment: 4
 */
import java.util.*;
public class MatricesofMenu
{    
    public static void myMenu(int a)
    {
        if (a == 5)
        {
            System.out.println("See you again.");
        }
        else 
        {
            System.out.println("Please select which matrix operation you want to enter and matching the integer value.");
            System.out.println("1. Addition of matrices");
            System.out.println("2. Scalar Multiplication");
            System.out.println("3. Multiplication of matrices");
            System.out.println("4. Determinant (only for 2 X 2 or 3 X 3 matrix)");
            System.out.println("5. Exit");
        }
    }

    //the method adds  up the two matrices with the same dimensions
    public static int[][] add(int[][]a, int[][]b)
    {
        int [][]c = a;

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }

    //checks if the addition operation can be carried out based on the array dimensions the user inputted.
    //matrices can only be added if they have identical dimensions
    public static boolean checkValidAdd(int[][]a, int[][]b)
    {
        if (a.length != b.length || a[0].length != b[0].length)
        {
            return false;
        }
        return true;
    }

    //multiplies every integer in matrix/array by a variable n
    public static int[][] scalarMultiply(int[][]a, int number)
    {
        int [][]b = a;

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                a[i][j] *= number;
            }
        }
        return b;
    }

    public static int[][] multiply(int a[][], int b[][]) 
    {

        int rowsA = a.length;
        int ColumnsA = a[0].length;
        int RowsB = b.length;
        int ColumnsB = b[0].length;

        //this program will have multiplication of two matrices.A number of rows equal to the number of rows in the first matrix
        //and a number of columns equal to the number of columns in the second matrix
        int[][] multiplication = new int[rowsA][ColumnsB];

        //the nested for loops carry out matrix multiplication; multiplication is carried out
        //row by row, column by column
        for(int i = 0; i < rowsA; i++) 
        { 
            for(int j = 0; j < ColumnsB; j++) 
            { 
                for(int k = 0; k < ColumnsA; k++) 
                { 
                    multiplication [i][j] += a[i][k] * b[k][j];
                }
            }  
        }
        return multiplication;
    }

    public static boolean checkingValidMultiplication(int a[][], int b[][])
    {
        int rowsA = a.length;
        int ColumnsA = a[0].length;
        int RowsB = b.length;
        int ColumnsB = b[0].length;

        //the matrices can only be multiplied if the number of columns in the first matrix identical the number
        //of rows in the second
        if (ColumnsA != RowsB ) 
        {
            return false;
        }
        return true;
    }

    public static int determinant(int[][]a)
    {
        int determinant=-1;

        if (a.length == 2)
        {
            determinant = (a[0][0]*a[1][1]) - (a[0][1]*a[1][0]);
        }
        else 
        {
            determinant = ((a[0][0]*a[1][1]*a[2][2])+(a[0][1]*a[1][2]*a[2][0])+(a[0][2]*a[2][1]*a[1][0]))-((a[0][2]*a[1][1]*a[2][0])+(a[0][1]*a[1][0]*a[2][2])+(a[0][0]*a[2][1]*a[1][2]));
        }

        return determinant;
    }

    //below: To gets the dimensions of a matrix and creates an appropriate array
    public static int[][] findTheMatrixDimensions()
    {
        int row=0, col=0;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter an number that matching to the interger of rows in the array.");
        row = input.nextInt();
        System.out.println("Please enter an number that matching to the interger of columns in the array.");
        col = input.nextInt();

        int[][]a = new int[row][col];
        return a;
    }

    //below : reads values into an array and see what the user input
    public static int[][] readingTheArray(int[][]a)
    {   
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                System.out.println("Please enter an number that matching to value found in row "+(i+1)+" and column "+(j+1)+".");
                a[i][j] = input.nextInt();
            }
        }
        return a;
    }

    public static void printingTheArray(int[][]a)
    {
        int length = 1;

        for (int i=0; i < a.length;i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                System.out.print(a[i][j]+"\t");
                length++;

                if (length > a[0].length)
                {
                    System.out.print("\n");
                    length = 1;
                }
            }
        }
    }

    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        int [][]matrix1;
        int [][]matrix2;
        int [][]result;
        int solutions = 0;
        boolean valid = false;

        myMenu(solutions);
        solutions = input.nextInt();

        while (solutions!= 5)
        {
            switch (solutions)
            {
                case 1: matrix1 =  findTheMatrixDimensions();
                matrix2 =  findTheMatrixDimensions();
                valid = checkValidAdd(matrix1, matrix2);
                if (valid == true)
                {
                    readingTheArray(matrix1);
                    readingTheArray(matrix2);
                    result = add(matrix1, matrix2);
                    printingTheArray(result);
                    System.out.print("\n");
                }
                else 
                {
                    System.out.println("Invalid addition! Matrix dimensions must match.\n");
                }
                solutions = 0;
                myMenu(solutions);
                solutions = input.nextInt();
                break;

                case 2: matrix1 =  findTheMatrixDimensions();
                readingTheArray(matrix1);
                System.out.println("Enter your scalar.");
                int scalar = input.nextInt();
                result = scalarMultiply(matrix1, scalar);
                printingTheArray(result);
                System.out.print("\n");
                solutions= 0;
                myMenu(solutions);
                solutions= input.nextInt();
                break;

                case 3: matrix1 =  findTheMatrixDimensions();
                matrix2 =  findTheMatrixDimensions();
                valid =checkingValidMultiplication(matrix1, matrix2);
                if (valid == true)
                {
                    readingTheArray(matrix1);
                    readingTheArray(matrix2);
                    result = multiply(matrix1, matrix2);
                    printingTheArray(result);
                    System.out.print("\n");
                }
                else
                {
                    System.out.println("Invalid multiplication! The number of columns in matrix 1 must match the number of rows in matrix 2.\n");
                }
                solutions = 0;
                myMenu(solutions);
                solutions= input.nextInt();               
                break;

                case 4: matrix1 =  findTheMatrixDimensions();
                if (matrix1.length != matrix1[0].length) //below: the matrices must be squares to calculate determinates
                {
                    System.out.println("Determinants can only be computed for square matrices!\n");
                }
                else if (matrix1.length > 3 || matrix1.length < 2)
                {
                    System.out.println("This program only calculates determinants of 2x2 or 3x3 matrices.\n");
                }
                else
                {
                    readingTheArray(matrix1);
                    int determinant;
                    determinant = determinant(matrix1);
                    System.out.println("Discriminant: "+determinant);
                    System.out.print("\n");
                }
                solutions= 0;
                myMenu(solutions);
                solutions = input.nextInt();
                break;

                default: System.out.println("Invalid reponse. Enter new integer.");
                solutions = input.nextInt();
                break;
            }
        }
        myMenu(5); //the is when the users exits the program. The line prints closing memo.
    }
}
