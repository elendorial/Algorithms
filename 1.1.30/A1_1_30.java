import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class A1_1_30
{

    public static int gcd(int a, int b)
    {
        if(b == 0) return a;
        else
            return gcd(b, a % b);

    }

    public static void main(String[] args)
    {

        int[][] mat = new int[30][30];

        for(int i = 0; i < 30; i++)
            for(int j = 0; j < 30; j++)
                if(gcd(i, j) == 1) mat[i][j] = 1;

        int count = 0;


        for(int i = 0; i < 30; i++)
            for(int j = 0; j < 30; j++)
            {
                if(count % 30 == 0) System.out.printf("\n");
                count++;
                System.out.printf("%d ", mat[i][j]);
            }
        System.out.printf("\n");



    }
}


