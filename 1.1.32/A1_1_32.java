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
import edu.princeton.cs.algs4.StdDraw;
import java.lang.Math;
import java.util.*;

public class A1_1_32
{

    public static void freq(double[] a, double l, double r, int N)
    {
        int[] frequencies = new int[N];
        double step = (r - l) / N;

        for(int i = 0; i < a.length; i++)
        {
            int index = (int)Math.floor((a[i] - l) / step);
            if(index == N)
            {
                frequencies[N-1] += 1;
                continue;
            }
            else
                frequencies[index] += 1;
        }

        int max = -1;
        for(int i = 0; i < frequencies.length; i++)
        {
            if(frequencies[i] > max) max = frequencies[i];
        }

        StdDraw.setCanvasSize(1280, 720);
        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, 2 * max);
        ///StdDraw.setPenRadius(0.5);

        for(int i = 0; i < N; i++)
        {
            double x = l + step * i + 0.5 * step;
            double y = frequencies[i] / 2.0;
            double rw = 0.5 * step;
            double rh = frequencies[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }


    }



    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        In in = new In(args[1]);
        double[] whitelist = in.readAllDoubles();
        //Arrays.sort(whitelist);

        double l = whitelist[0];
        double r = whitelist[whitelist.length - 1];

        double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < whitelist.length; i++)
        {
            if (whitelist[i] < min) min = whitelist[i];
        }

        double max = -1;

        for(int i = 0; i < whitelist.length; i++)
        {
            if(whitelist[i] > max) max = whitelist[i];
        }

        freq(whitelist, min, max, N);



    }


}


