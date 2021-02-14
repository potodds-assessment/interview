package sort;

import java.util.Arrays;

/*
In computer science, merge sort (also commonly spelled mergesort) is an O(n log n) comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the implementation preserves the input order of equal elements in the sorted output. Mergesort is a divide and conquer algorithm. Divide and conquer algorithms divide the original data into smaller sets of data to solve the problem.
During the Mergesort process the object in the collection are divided into two collections. To split a collection, Mergesort will take the middle of the collection and split the collection into its left and its right part. The resulting collections are again recursively splitted via the Mergesort algorithm until they are broke to single element in each collection.
After splitting each collection, mergesort algorithm start combining all collections obtained via above procedure. To combine both collections Mergesort start at each collection at the beginning. It pick the object which is smaller and inserts this object into the new collection. For this collection it now selects the next elements and selects the smaller element from both collection by comparing one element from each collection at a time.
This process create a collection of sorted elements (subset of all elements which needs to be sorted). This process is recursively done for all available collections obtained in first step i.e. splitting the collections.
Once all elements from both collections have been inserted in the new collection, Mergesort has successfully sorted the collection.
To avoid the creation of too many collections, typically only one new collection is created and the new one and existing one are treated as different collections.
 */


/* Java program for Merge Sort */
class MergeSort 
	{
		// Merges two subarrays of arr[].
		// First subarray is arr[l..m]
		// Second subarray is arr[m+1..r]
		void merge(int arr[], int l, int m, int r)
		{
			// Find sizes of two subarrays to be merged
			int n1 = m - l + 1;
			int n2 = r - m;

			/* Create temp arrays */
			int L[] = new int[n1];
			int R[] = new int[n2];

			/*Copy data to temp arrays*/
			for (int i = 0; i < n1; ++i)
				L[i] = arr[l + i];
			for (int j = 0; j < n2; ++j)
				R[j] = arr[m + 1 + j];

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarry array
			int k = l;
			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					arr[k] = L[i];
					i++;
				}
				else {
					arr[k] = R[j];
					j++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}

		// Main function that sorts arr[l..r] using
		// merge()
		void sort(int arr[], int l, int r)
		{
			if (l < r) {
				// Find the middle point
				int m = (l + r) / 2;

				// Sort first and second halves
				sort(arr, l, m);
				sort(arr, m + 1, r);

				// Merge the sorted halves
				merge(arr, l, m, r);
			}
		}

		/* A utility function to print array of size n */
		static void printArray(int arr[])
		{
			int n = arr.length;
			for (int i = 0; i < n; ++i)
				System.out.print(arr[i] + " ");
			System.out.println();
		}

		// Driver code
		public static void main(String args[])
		{
			int arr[] = { 12, 11, 13, 5, 6, 7 };

			System.out.println("Given Array");
			printArray(arr);

			MergeSort ob = new MergeSort();
			ob.sort(arr, 0, arr.length - 1);

			System.out.println("\nSorted array");
			printArray(arr);
		}
	/* This code is contributed by Rajat Mishra */



/*
public static void main(String[] args) 
{
    //Unsorted array
    Integer[] a = { 2, 6, 3, 5, 1 };
     
    //Call merge sort
    mergeSort(a);
     
    //Check the output which is sorted array
    System.out.println(Arrays.toString(a));
}
*/

@SuppressWarnings("rawtypes") 
public static Comparable[] mergeSort(Comparable[] list) 
{
    //If list is empty; no need to do anything
    if (list.length <= 1) {
        return list;
    }
     
    //Split the array in half in two parts
    Comparable[] first = new Comparable[list.length / 2];
    Comparable[] second = new Comparable[list.length - first.length];
    System.arraycopy(list, 0, first, 0, first.length);
    System.arraycopy(list, first.length, second, 0, second.length);
     
    //Sort each half recursively
    mergeSort(first);
    mergeSort(second);
     
    //Merge both halves together, overwriting to original array
    merge(first, second, list);
    return list;
}
 
@SuppressWarnings({ "rawtypes", "unchecked" }) 
private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) 
{
    //Index Position in first array - starting with first element
    int iFirst = 0;
     
    //Index Position in second array - starting with first element
    int iSecond = 0;
     
    //Index Position in merged array - starting with first position
    int iMerged = 0;
     
    //Compare elements at iFirst and iSecond, 
    //and move smaller element at iMerged
    while (iFirst < first.length && iSecond < second.length) 
    {
        if (first[iFirst].compareTo(second[iSecond]) < 0) 
        {
            result[iMerged] = first[iFirst];
            iFirst++;
        } 
        else
        {
            result[iMerged] = second[iSecond];
            iSecond++;
        }
        iMerged++;
    }
    //copy remaining elements from both halves - each half will have already sorted elements
    System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
    System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
}
}

