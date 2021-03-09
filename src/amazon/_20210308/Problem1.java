package amazon._20210308;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

	private static int sumArray(List<Integer> arr) {
		int sum = 0;
		for(Integer i : arr) {
			sum+=i;
		}
		return sum;
	}
	
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
    	List<Integer> list = new ArrayList<>();

    	if ( arr == null || arr.size() == 1)
    		return list; 
    	

    	int sumArray = sumArray(arr);
    	Collections.sort(arr);
    	
    	int sumEndValues = 0;
    	for(int index=arr.size()-1; index>=0; index--) {
    		int endValue = arr.get( index );    		

    		list.add(endValue);
    		sumEndValues += endValue;
    		if ( sumEndValues > ( sumArray - sumEndValues ) )
    			break;
    	}  	
    	
    	Collections.sort(list);
    	int retSum = sumArray(list);
    	System.out.println(retSum + "," + list.size() + "," + sumArray + "," + arr.size() + "," + (sumArray-retSum));
    	return list;
    }
	
    /*
     * 4 5
     */
    public List<Integer> getTestCase1() {
    	List<Integer> list = new ArrayList<>();
    	list.add(5);
    	list.add(3);
    	list.add(2);
    	list.add(4);
    	list.add(1);
    	list.add(2);
    	return list;
    }

    /*
     * 5 6
     */
    public List<Integer> getTestCase2() {
    	List<Integer> list = new ArrayList<>();
    	list.add(4);
    	list.add(2);
    	list.add(5);
    	list.add(1);
    	list.add(6);
    	return list;
    }
    
    public List<Integer> getTestCase3() {
    	List<Integer> list = new ArrayList<>();
    	list.add(5);
    	list.add(5);
    	list.add(5);
    	list.add(3);
    	list.add(3);
    	list.add(2);
    	list.add(4);
    	list.add(4);
    	list.add(1);
    	list.add(2);
    	return list;
    }    
    
    public List<Integer> getTestCase4() {
    	List<Integer> list = new ArrayList<>();

    	try {
            Scanner myReader = new Scanner(new File("C:/Users/lapwa/Downloads/amazon/input006.txt"));
            int total = 0;
            while (myReader.hasNextLine()) {
            	Integer number = Integer.valueOf(myReader.nextLine());
            	list.add(number);
            	total += number;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }

    	return list;
    }    
    
	public void run() {
//		System.out.println(minimalHeaviestSetA(getTestCase1()));
//		System.out.println(minimalHeaviestSetA(getTestCase2()));
//		System.out.println(minimalHeaviestSetA(getTestCase3()));
		System.out.println(minimalHeaviestSetA(getTestCase4()));
	}
	
	public static void main(String[] args) {
		new Problem1().run();
	}

}
