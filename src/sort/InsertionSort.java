package sort;

import java.util.Arrays;

/*
The basic idea of insertion sort algorithm can be described as these steps:

1. Data elements are grouped into two sections: a sorted section and an un-sorted section.
2. Take an element from the un-sorted section.
3. Insert the element into the sorted section at the correct position based on the comparable property.
4. Repeat step 2 and 3 until no more elements left in the un-sorted section.
 */

public class InsertionSort {
    public static void main(String[] args) 
    {
        // This is unsorted array
        Integer[] array = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
 
        // Let's sort using insertion sort
        insertionSortImproved(array, 0, array.length);
 
        // Verify sorted array
        System.out.println(Arrays.toString(array));
    }
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void insertionSortImproved(Object[] a, int fromIndex, int toIndex) 
    {
        Object d;
        for (int i = fromIndex + 1; i < toIndex; i++)
        {
            d = a[i];
            int jLeft = fromIndex;
            int jRight = i - 1;
            //Check if its current position is it's suitable position
            if (((Comparable) a[jRight]).compareTo(d) > 0) 
            {
                //Perform binary search
                while (jRight - jLeft >= 2) 
                {
                    int jMiddle = (jRight - jLeft) / 2 + jLeft - 1;
                    if (((Comparable) a[jMiddle]).compareTo(d) > 0) {
                        jRight = jMiddle;
                    } else {
                        jLeft = jMiddle + 1;
                    }
                }
                if (jRight - jLeft == 1) 
                {
                    int jMiddle = jLeft;
                    if (((Comparable) a[jMiddle]).compareTo(d) > 0) {
                        jRight = jMiddle;
                    } else {
                        jLeft = jMiddle + 1;
                    }
                }
                //Place the element
                int j = i;
                for (j = i; j > jLeft; j--) 
                {
                    a[j] = a[j - 1];
                }
                a[j] = d;
            }
        }
    }
}
