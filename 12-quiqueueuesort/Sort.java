/*========== Sort.java ==========
  
  Class used to test various sorting algorithms.
  The constructor will create an array of ints and then
  populate them with random values.
  
  The class also contains variables to keep track
  of the number of swaps and comparisons performed
  for a given sort.
=========================*/

//import java.io.*;
//import java.util.*;
import java.util.Arrays;
import java.util.Random;

public class Sort {
	
	public static int DEFAULT_SIZE = 1000;
	
	/*======== public void populate()) ==========
	  Inputs:  int[] list
	  Returns: 
	  
	  populates the list with random ints in the
	  range [0, list.length)
	  ====================*/
	public static void populate(int[] list) {
		Random r = new Random();
		for(int i=0; i<list.length; i++)
			list[i] = r.nextInt() % list.length;
	}
	
	/*======== public void duplicate () ==========
	  Inputs:  int[] a
	  Returns: A new array of ints that is an exact
	           duplicate of a
	  ====================*/
	public static int[] duplicate(int[] a) {
		int[] n = new int[ a.length ];
		
		for(int i=0; i<a.length; i++)
			n[i] = a[i];
		
		return n;
	}
	
	public static String show(int[] list) {
		String s = "[";
		for(int i=0; i<list.length-1; i++)
			s += list[i] + ", ";
		return s + list[list.length-1] + "]";
	}
	
	
	/*======== public boolean isSorted()) ==========
	  Inputs:  
	  Returns: true if the list is sorted
	           false if the list is unsorted
	  
	  ====================*/
	public static boolean isSorted(int[] list) {
		for(int i=0; i<list.length-1; i++)
			if(list[i] > list[i+1])
				return false;
		return true;
	}
 	
	public static void insertionSort(int[] a) {
		int t, pos;
		for(int i=1; i<a.length; i++) {
			pos = i;
			t = a[pos];
			while(pos>0 && a[pos-1]>t ) {
				a[pos] = a[pos-1];
				pos--;
			}
			a[pos] = t;
		}
	}
	
	
	/*======== public static int[] merge() ==========
	  Inputs:  int[] a
	           int[] b
	  Returns: A new sorted array containing the
	           combined elements of a and b
	  
	  This method must run in linear time.
	  ====================*/
	public static int[] merge(int[] a, int[] b) {
		int[] sorted = new int[a.length + b.length];
		int aCount = 0;
		int bCount = 0;
		int sCount = 0;
		
		while(aCount<a.length && bCount<b.length) {
			if(a[aCount] < b[bCount]) {
				sorted[sCount] = a[aCount];
				aCount++;
			}
			else {
				sorted[sCount] = b[bCount];
				bCount++;
			}
			sCount++;
		}
		
		while(aCount<a.length) {
			sorted[sCount] = a[aCount];
			sCount++;
			aCount++;
		}
		
		while(bCount<b.length) {
			sorted[sCount] = b[bCount];
			sCount++;
			bCount++;
		}
		
	 	return sorted;
	}
	
	public static int[] mergeSort(int[] list) {
		if ( list.length == 1 )
			return list;
		else {
			int mid = list.length/2;
			int[] a = new int[mid];
			int[] b = new int[list.length-mid];
			int i=0;
			for (; i<a.length; i++ )
				a[i] = list[i];
			for(int j=0; j<b.length; j++)
				b[j] = list[i+j];
			
			return merge(mergeSort(a), mergeSort(b));
		}
	}
	
	
	
	/*======== public void swap() ==========
	  Inputs:  int a
	           int b
	  Returns: 
	  
	  Swaps the values at postitons a and b in list
	  ====================*/	
	public static void swap(int[] list, int a, int b) {
		int c = list[a];
		list[a] = list[b];
		list[b] = c;
	}
	
	/*======== public static int partition() ==========
	  Inputs:  int[] a
	           int start
	           int end
	  Returns: The index that marks the end of the first partition
	  
	  This method should select a pivot value, then split the
	  array such that each element in the left side of the array
	  is less than the pivot and every element in the right side
	  of the array is greater than or equal to the pivot.
	  
	  The return value should represent the last index of the
	  left (smaller) side of the array
	  
	  This method must run in linear time.
	  ====================*/
	public static int partition(int[] a, int start, int end) {
		int mid = start/2 + end/2 + ((start%2 == 1) ? 1 : end%2);
		int pivotVal = a[mid];
		int front = start;
		swap(a, mid, end);
		for(int i=start; i<end; i++) {
			if(a[i] < pivotVal) {
				swap(a, i, front);
				front++;
			}
		}
		swap(a, front, end);
		return front;
	}
	
	public static void quicksort(int[] a) {
		quiquesort(a, 0, a.length-1);
	}
	
	public static void quiquesort(int[] a, int start, int end) {
		if(start < end) {
			int div = partition(a, start, end);
			quiquesort(a, start, div-1);
			quiquesort(a, div+1, end);
		}
	}
	
	public static void main(String[] args) {
		//Testing mergeSort
		/*
		int[] a1 = new int[10];
		int[] a2 = new int[10];

		populate(a1);
		populate(a2);
		insertionSort(a1);
		insertionSort(a2);
		System.out.println( show(a1) );
		System.out.println( show(a2) );

		int[] merged = merge( a1, a2 );
		System.out.println( show( merged ) );

		int[] list = new int[10];
		populate(list);
		System.out.println( show( list ) );
		list = mergeSort(list);
		System.out.println( show( list ) );
		*/
		//Testing quiquesort
		/*int[] q1 = new int[20];
		populate(q1);
		System.out.println(show(q1));
		int foo = partition(q1, 0, q1.length-1);
		System.out.printf("pivotIndex = %d, pivotVal = %d%n", foo, q1[foo]);
		System.out.printf("%s%n%n", show(q1));
		
		int[] q2 = new int[20];
		populate(q2);
		System.out.println(show(q2));
		int bar = partition(q2, 0, q2.length/2);
		System.out.printf("pivotIndex = %d, pivotVal = %d%n", bar, q2[bar]);
		System.out.printf("%s%n%n", show(q2));
		
		int[] q3 = new int[20];
		populate(q3);
		System.out.println(show(q3));
		int meh = partition(q3, 10, 19);
		System.out.printf("pivotIndex = %d, pivotVal = %d%n", bar, q3[meh]);
		System.out.printf("%s%n%n", show(q3));*/
		
		for(int i=0; i<100000; i++) {
			int[] qu1 = new int[i];
			populate(qu1);
			quicksort(qu1);
			System.out.printf("%b%d%n", isSorted(qu1), i);
		}
		
	}
}
