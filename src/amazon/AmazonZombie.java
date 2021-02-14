package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AmazonZombie {
	
	public int[][] generateData() {
		int data[][] = new int[][] {
				{0,1,1,0,1},
				{0,1,0,1,0},
				{0,0,0,0,1},
				{0,1,0,0,0}
		};
		
		return data;
	}
	
	public List<List<Integer>> convertToListArray(int[][] data) {
		List<List<Integer>> finalList = new ArrayList<>();
		for(int[] arr : data) {
			List<Integer> dataList = Arrays.stream(arr).boxed().collect(Collectors.toList());
			finalList.add(dataList);
		}
		return finalList;
	}
	
	public void printData(int[][] data) {
		for(int row = 0; row < data.length; row++) {
			for(int column = 0; column < data[row].length; column++) {
				System.out.println("row[" + row + "], column[" + column + "], data[" + data[row][column] + "]" );
			}
		}
		System.out.println("============================================");
	}

	public boolean setData(int row, int column, int rowMax, int columnMax, int[][] data, int[][] cloneData) {
		boolean dataChanged = false;
		if (data[row][column] == 1) {			
			int leftOffset = row-1;
			int topOffset = column-1;
			int rightOffset = row+1;
			int bottomOffset = column+1;

			if (leftOffset >= 0 && data[leftOffset][column] == 0) {
				cloneData[leftOffset][column] = 1;
				dataChanged = true;
			}
			if (topOffset >= 0 && data[row][topOffset] == 0) {
				cloneData[row][topOffset] = 1;
				dataChanged = true;
			}
			if (rightOffset < rowMax && data[rightOffset][column] == 0) {
				cloneData[rightOffset][column] = 1;
				dataChanged = true;
			}
			if (bottomOffset < columnMax && data[row][bottomOffset] == 0) {
				cloneData[row][bottomOffset] = 1;
				dataChanged = true;
			}
		}
		return dataChanged;
	}

	public boolean isDone(int[][] data) {
		for(int row = 0; row < data.length; row++) {
			for(int column = 0; column < data[row].length; column++) {
				if (data[row][column] == 0)
					return false;
			}
		}
		return true;
	}

	public void processData(int[][] data) {
		int rowMax = data.length;
		int columnMax = data[0].length;
		int iteration = 0;
		int[][] cloneData = Arrays.stream(data).map(el -> el.clone()).toArray($ -> data.clone());
		int[][] clone2Data = Arrays.stream(data).map(el -> el.clone()).toArray($ -> data.clone());
		
		do {
			cloneData = new int[3][2];
			printData(data);
			for(int row = 0; row < rowMax; row++) {
				for(int column = 0; column < columnMax; column++) {
					setData(row, column, rowMax, columnMax, data, cloneData);
				}
			}
			iteration++;
			printData(data);
		} while( !isDone( cloneData ) );
		System.out.println("Number of iteration[" + iteration + "]");
	}
	
	public void run() {
		int[][] data = generateData();
		System.out.println("rows[" + data.length + "], columns[" + data[0].length + "]");
		System.out.println("============================================");

		List<List<Integer>> dataList = this.convertToListArray(data);
		System.out.println("rows[" + dataList.size() + "], columns[" + dataList.get(0).size() + "]");
		System.out.println("============================================");

		processData(data);
		printData(data);
	}
	
	public static void main(String[] args) {
		(new AmazonZombie()).run();
	}
}
