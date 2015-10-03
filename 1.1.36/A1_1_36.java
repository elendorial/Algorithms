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


