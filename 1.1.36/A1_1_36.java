/*The MIT License (MIT)

Copyright (c) 2015 Viktor Daropoulos

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/



import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;



public class A1_1_36
{
    public static int[][] shuffle(int[] mat, int N, int M)
    {

        int[][] table = new int[M][M];

        for(int i = 0; i < N; i++)
        {
            StdRandom.shuffle(mat);

            for(int j = 0; j < M; j++)
                table[mat[j]][j] += 1;

            for(int j = 0; j < M; j++)
                mat[j] = j;
        }

        return table;

    }


    public static void main(String[] args)
    {

        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int[][] table = new int[M][M];
        int counter = 0;

        int[] mat = new int[M];
        for(int i = 0; i < M; i++)
            mat[i] = i;

        table = shuffle(mat, N, M);

        for(int i = 0; i < M; i++)
        {
            for(int j = 0; j < M; j++)
            {
                if(counter % M == 0) System.out.printf("\n");
                System.out.printf("%d   ", table[i][j]);
                counter++;
            }
        }

        System.out.printf("\n");

    }
}


