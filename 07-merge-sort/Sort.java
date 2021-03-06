/*========== Sort.java ==========

  Class used to test various sorting algorithms.
  The constructor will create an array of ints and then
  populate them with random values.
  
  The class also contains variables to keep track
  of the number of swaps and comparisons performed
  for a given sort.

  Complete bubble(), selection() and insertion()
jdyrlandweaver
=========================*/

//import java.io.*;
//import java.util.*;
import java.util.Random;
import java.util.Arrays;

public class Sort {
	
	public static int DEFAULT_SIZE = 1000;
	
	/*======== public void populate()) ==========
	  Inputs: int[] list
	  Returns: 
	  
	  populates the list with random ints in the
	  range [0, list.length)
	  ====================*/
	public static void populate(int[] list) {
		Random r = new Random();
		for (int i=0; i<list.length; i++) {
			list[i] = r.nextInt() % list.length;
		}
	}
	
	/*======== public void duplicate () ==========
	  Inputs:  int[] a
	  Returns: A new array of ints that is an exact
			   duplicate of a
	  ====================*/
	public static int[] duplicate (int[] a) {
		int[] n = new int[ a.length ];
		
		for (int i=0; i<a.length; i++) {
			n[i] = a[i];
		}
		
		return n;
	}
	
	public static String show(int[] list) {
		String s = "[";
		
		for (int i=0; i<list.length; i++) {
			s = s + list[i] + (i==list.length-1?"":", ");
		}
		
		return s + "]";
	}
	
	public static void print(int[] list) {
		System.out.printf("[");
		for(int i=0; i<list.length; i++) {
			System.out.printf("%2s",list[i]);
			if(i!=list.length-1) System.out.printf(", ");
		}
		System.out.printf("]%n");
	}
	
	/*======== public boolean isSorted()) ==========
	  Inputs:  
	  Returns: true if the list is sorted
			   false if the list is unsorted
	  
	  ====================*/
	public static boolean isSorted(int[] list) {
		for (int i=0; i<list.length - 1; i++) {
			if (list[i] > list[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	/*======== public void swap() ==========
	  Inputs:  int a
			   int b
	  Returns: 
	  
	  Swaps the values at postitons a and b in list
	  ====================*/
	public static void swap(int a, int b, int[] list) {
		int c = list[a];
		list[a] = list[b];
		list[b] = c;
	}
	
	public static void insertionSort(int[] a) {
		int t, pos;
		for (int i=1; i<a.length; i++) {
			pos = i;
			t = a[pos];
			while (pos>0 && a[pos-1]>t) {
				a[pos] = a[pos-1];
				pos --;
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
	public static int[] merge(int[] a, int[] b)  {
		int[] sorted = new int[a.length + b.length];
		int indexA, indexB, indexS;
		indexA = indexB = indexS = 0;
		
		while(indexS < sorted.length) {
			if(indexA >= a.length) {
				sorted[indexS] = b[indexB];
				indexB++;
			}
			else if(indexB >= b.length) {
				sorted[indexS] = a[indexA];
				indexA++;
			}
			else if(a[indexA] < b[indexB]) {
				sorted[indexS] = a[indexA];
				indexA++;
			}
			else {
				sorted[indexS] = b[indexB];
				indexB++;
			}
			indexS++;
		}
		return sorted;
	}
	
	public static int[] mergeSort(int[] list) {
		if(list.length <= 1) {
			return list;
		}
		
		return merge(mergeSort(Arrays.copyOfRange(list,0,list.length/2)), mergeSort(Arrays.copyOfRange(list,list.length/2,list.length)));
	}
	
	
	public static void main(String[] args) {
		/*int[] a1 = new int[10];
		int[] a2 = new int[10];
		
		populate(a1);
		populate(a2);
		
		insertionSort(a1);
		insertionSort(a2);
		
		System.out.println(show(a1));
		System.out.println(show(a2));
		
		int[] merged = merge(a1,a2);
		System.out.println(show(merged));
		*/
		int[] foo = new int[11];
		print(foo);
		
		populate(foo);
		print(foo);
		
		mergeSort(foo);
		print(mergeSort(foo));
	}
}
