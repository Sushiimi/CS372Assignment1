/*
***************************************************
*
*  Ian Johnson -- 2/7/2018 -- CS372 Algorithms
*  this program determine the runtime for both
*  algorithms meant to find a given index of the
*  fibonacci sequence (i.e. n = 3, find the 3rd
*  fibonacci number) and the print the runtimes
*  for both algorithms for comparison
*
***************************************************
*/

// import statements
import java.util.*;
import java.io.*;
import java.lang.*;

public class algotesting {

// recursive exponetial algorithm for fibonacci
	public static int fib1( int n ) {
		// base cases
		if ( n == 0 )
			return 0;
		if ( n == 1 )
			return 1;

		// recursive case
		return fib1( n - 1 ) - fib1( n - 2 );
	}// end fib1

// iterative polynomial algorithm for fibonacci
	public static int fib2( int n ) {
		// base case
		if ( n == 0 )
			return 0;

		// recursive case
		int f[] = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for ( int i = 2; i < n; i++ )
			f[i] = f[i - 1] + f[i - 2];
		return f[n];
	}// end fib2

// main function
	public static void main( String args[] ) {
		// vars and objs
		int inputVals[] = new int[10];
		long startTime = 0;
		long fib1RunTimes[] = new long[10];
		long fib2RunTimes[] = new long[10];
		Scanner scan = new Scanner( System.in );

		// get 10 input values from user
		System.out.println("\n|=================================================================|");
		System.out.println("|   Please enter 10 values for n to be passed to the algorithms   |");
		System.out.println("|=================================================================|\n");
		for ( int i = 0; i < inputVals.length; i++ )
			inputVals[i] = scan.nextInt();

		// run the algorithms with the given values, store
		// the runtime value for each iteration
		for ( int j = 0; j < inputVals.length; j++ ) {
			startTime = System.nanoTime();
			fib1( inputVals[j] );
			fib1RunTimes[j] = System.nanoTime() - startTime;
			startTime = 0;
			startTime = System.nanoTime();
			fib2( inputVals[j] );
			fib2RunTimes[j] = System.nanoTime() - startTime;
			startTime = 0;
		}

		// print out the stored runtime values
		System.out.println("|=================================================================|");
		System.out.println("|                Runtime values for given n-values                |");
		System.out.println("|=================================================================|");
		System.out.println("|  n-value  |  fib1 runtime(nanosecs)  |  fib2 runtime(nanosecs)  |");
		System.out.println("|=================================================================|");
		for ( int k = 0; k < inputVals.length; k++ )
	    	System.out.printf("|     %-3d   |  %-,24d|  %-,24d|\n", 
	    		               inputVals[k], fib1RunTimes[k], fib2RunTimes[k]);
		System.out.println("|=================================================================|");

		// run the algorithms to determine the max n for fib1 and 
		// fib2 to finish in < 10 milliseconds 

	}// end main
}// end class