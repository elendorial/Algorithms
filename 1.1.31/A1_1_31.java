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

           for(int i = 0; i < N - 1; i++)
           {
            if(StdRandom.random() < p)
                StdDraw.line(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
           }

            StdDraw.show();

        }
    }


