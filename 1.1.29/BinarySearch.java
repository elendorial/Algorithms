import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

public class BinarySearch
{

	private BinarySearch() { }

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
        int temp = -1;
        while(val != -1)
        {
            temp = val;
            val = indexOf(key, a, 0, val - 1);
        }

        return temp;

    }

    public static int count(int key, int[] a)
    {
        int val = indexOf(key, a, 0, a.length - 1);
        int temp = val;
        int count = 0;

        while(val != -1)
        {
            count++;
            val = indexOf(key, a, 0, val - 1);
        }

        val = indexOf(key, a, temp + 1, a.length - 1);

        while(val != -1)
        {
            count++;
            val = indexOf(key, a, val + 1, a.length - 1);
        }

        return count;
    }

	public static void main(String[] args)
	{
		In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

		Arrays.sort(whitelist);

		while(!StdIn.isEmpty())
		{
			int key = StdIn.readInt();
            System.out.println(count(key,whitelist));
		}
	}
}


