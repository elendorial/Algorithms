import edu.princeton.cs.algs4.StdRandom;


public class A1_1_35
{

    public static double[] dice()
    {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for(int i = 1; i <= SIDES; i++)
            for(int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;

        for(int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        return dist;
    }

    public static double[] dice_throw(int N)
    {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];

        for(int i = 0; i < N; i++)
        {
            int dice1 = StdRandom.uniform(1, 7);
            int dice2 = StdRandom.uniform(1, 7);
            dist[dice1 + dice2] += 1.0;
        }

        for(int k = 2; k <= 2 * SIDES; k++)
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


