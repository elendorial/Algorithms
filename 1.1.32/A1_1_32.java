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


