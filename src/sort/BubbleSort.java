package sort;

import java.util.Arrays;
/*
The basic idea of Bubble Sort algorithm can be described as these steps:

1. Data elements are grouped into two sections: a sorted section and an un-sorted section.
2. Go through every element in the un-sorted section and re-arrange its position with its neighbor to put the element with higher order on the higher position. At the end, the element with the highest order will be on top of the un-sorted section, and moved to the bottom of the sorted section.
3. Repeat step 2 until no more elements left in the un-sorted section.
 */
public class BubbleSort {
    public static void main(String[] args) 
    {
        // This is unsorted array
        Integer[] array = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
 
        // Let's sort using bubble sort
        bubbleSort(array, 0, array.length);
 
        // Verify sorted array
        System.out.println(Arrays.toString(array));
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void bubbleSort(Object[] array, int fromIndex, int toIndex) 
    {
        Object d;
        for (int i = toIndex - 1; i > fromIndex; i--) 
        {
            boolean isSorted = true;
            for (int j = fromIndex; j < i; j++) 
            {
                //If elements in wrong order then swap them
                if (((Comparable) array[j]).compareTo(array[j + 1]) > 0) 
                {
                    isSorted = false;
                    d = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = d;
                }
            }
            //If no swapping then array is already sorted
            if (isSorted)
                break;
        }
    }
}
