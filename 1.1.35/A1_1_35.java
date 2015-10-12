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



import edu.princeton.cs.algs4.StdRandom;


public class A1_1_35
{

    public static double[] dice()
    {

        double[] dist = new double[13];
        for(int i = 1; i <= 6; i++)
            for(int j = 1; j <= 6; j++)
                dist[i + j] += 1.0;

        for(int k = 2; k <= 12; k++)
            dist[k] /= 36.0;

        return dist;
    }

    public static double[] dice_throw(int N)
    {

        double[] dist = new double[13];

        for(int i = 0; i < N; i++)
        {
            int dice1 = StdRandom.uniform(1, 7);
            int dice2 = StdRandom.uniform(1, 7);
            dist[dice1 + dice2] += 1.0;
        }

        for(int k = 2; k <= 12; k++)
            dist[k] /= N;

        return dist;

    }



    public static void main(String[] args)
    {
        double[] mat, mat_new;

        mat = dice();

        for(int i = 2; i < 13; i++)
            System.out.printf("%f  ", mat[i]);
        System.out.printf("\n");

        mat_new = dice_throw(800000);

        for(int i = 2; i < 13; i++)
            System.out.printf("%f  ", mat_new[i]);
        System.out.printf("\n");


    }
}


