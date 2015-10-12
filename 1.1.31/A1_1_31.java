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
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.lang.Math;

public class A1_1_31
{


    public static void main(String[] args)
    {

        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        p = Math.max(0,Math.min(1,p));
        double x, y, theta, r;
        double points[][] = new double[N][2];

        StdDraw.setPenRadius(.05);
        StdDraw.setCanvasSize(1280, 720);
        StdDraw.setXscale(-640, 640);
        StdDraw.setYscale(-360, 360);

        for(int i = 0; i < N; i++)
        {
            theta = Math.toRadians(i * 360.0 / N);
            x = 300 * Math.cos(theta);
            y = 300 * Math.sin(theta);
            points[i][0] = x;
            points[i][1] = y;
            StdDraw.point(x, y);
        }

        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.setPenRadius();

        for(int i = 0; i < N; i++)
        {
            for(int j = i + 1; j < N; j++)
            {
                if(StdRandom.random() <= p)
                    StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
            }

        }

        StdDraw.show();

    }
}


