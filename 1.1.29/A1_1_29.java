import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class A1_1_29
{

    public static int indexOf(int key, int[] a, int lo, int hi)
    {
        if(lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid])
            return indexOf(key, a, lo, mid - 1);
        else if(key > a[mid])
            return indexOf(key, a, mid + 1, hi);
        else
            return mid;
    }

    public static int rank(int key, int[] a)
    {
        int val = indexOf(key, a, 0, a.length - 1);
        int temp = 0;
        while(val != -1)
        {
            temp = val;
            val = indexOf(key, a, 0, val - 1);
        }
        return temp;

    }

    public static int count(int key, int[] a)
    {

        int counter = 0;
        int i = rank(key, a);

        while(i < a.length && a[i++] == key) counter++;

        return counter;

    }

    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        Arrays.sort(whitelist);
        int key = Integer.parseInt(args[1]);

        System.out.println(rank(key, whitelist));

    }
}


