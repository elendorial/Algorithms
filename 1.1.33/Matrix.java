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


public class Matrix
{

    public static double dot(double[] x, double[] y)
    {
        double sum = 0.0;

        for(int i = 0; i < x.length; i++)
            sum += x[i] * y[i];

        return sum;
    }

    public static double[][] mult(double[][] a, double[][] b)
    {

        int a_rows = a.length;
        int a_cols = a[0].length;

        int b_rows = b.length;
        int b_cols = b[0].length;
        double[][] dist = new double[a_rows][b_cols];

        if(a_cols != b_rows) System.exit(-1);
        else
        {
            for(int i = 0; i < a_rows; i++)
            {
                for(int j = 0; j < b_cols; j++)
                {
                    double sum = 0;
                    for(int k = 0; k < a_cols; k++)
                    {
                        sum += a[i][k] * b[k][j];
                    }
                    dist[i][j] = sum;
                }
            }
        }
        return dist;
    }

    public static double[][] transpose(double[][] a)
    {
        int a_rows = a.length;
        int a_cols = a[0].length;

        double[][] dist = new double[a_cols][a_rows];

        for(int i = 0; i < a_cols; i++)
        {
            for(int j = 0; j < a_rows; j++)
            {
                dist[i][j] = a[j][i];
            }
        }

        return dist;
    }

    public static double[] mult(double[][] a, double[] x)
    {
        int a_rows = a.length;
        int a_cols = a[0].length;
        double[] vec = new double[a_rows];
        if(a_cols != x.length) System.exit(-1);
        else
        {
            for(int i = 0; i < a_rows; i++)
            {
                double sum = 0;
                for(int j = 0; j < a_cols; j++)
                {

                    sum += a[i][j] * x[j];
                }
                vec[i] = sum;
            }
        }
        return vec;
    }

    public static double[] mult(double[] y, double[][] a)
    {
        int a_rows = a.length;
        int a_cols = a[0].length;
        double[] vec = new double[a_cols];
        if(a_rows != y.length) System.exit(-1);
        else
        {
            for(int j = 0; j < a_cols; j++)
            {
                double sum = 0;
                for(int i = 0; i < a_rows; i++)
                {
                    sum += y[i] * a[i][j];
                }
                vec[j] = sum;
            }
        }
        return vec;
    }

}


