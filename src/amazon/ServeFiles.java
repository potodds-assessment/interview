package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ServeFiles {

	private int[][] convertToArray(List<List<Integer>> grid) {
		int[][] gridArray = new int[grid.size()][grid.get(0).size()];
		
		int y=0;
		for(List<Integer> row : grid) {
			for(int x=0; x<row.size(); x++) {
				gridArray[y][x] = row.get(x);
			}
			y++;
		}

		return gridArray; 
	}

	private boolean validate(int[][] array) {
		for(int y=0;y<array.length;y++) {
			for(int x=0;x<array[y].length;x++) {
				if ( array[y][x] == 0 )
					return false;
			}
		}
		return true;
	}
	
	int minimumHours(int rows, int columns, List<List<Integer>> grid) {
		
		int[][] gridArray = convertToArray(grid);
		int[][] result = new int[rows][columns];		

		boolean notDone = false;
		int count=0;
		
		do {
			for(int y=0; y<rows; y++) {
				for(int x=0; x<columns; x++) {
					if ( gridArray[y][x] == 1 ) {
						boolean left = x-1 < 0 ? false : true;
						boolean right = x+1 >= columns ? false : true;
						boolean bottom = y+1 >= rows ? false : true;
						boolean top = y-1 < 0 ? false : true;
						
						if (left ) result[y][x-1] = 1;
						if (right ) result[y][x+1] = 1;
						if (bottom ) result[y+1][x] = 1;
						if (top ) result[y-1][x] = 1;
						result[y][x] = 1;
					}
				}
			}			
			count++;			
			gridArray = result;
			result = new int[rows][columns];
			notDone = validate(gridArray);
		} while(!notDone);
		
		return count;
	}
	
	/*
	 * answer: 2
	 */
	public List<List<Integer>> getTestCase1() {
		List<List<Integer>> result = new ArrayList<>();
		result.add(Arrays.stream(new int[] {0,1,1,0,1}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,1,0,1,0}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,0,0,0,1}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,1,0,0,0}).boxed().collect(Collectors.toList()));
		return result;
	}
	
	/*
	 * answer: 4
	 */
	public List<List<Integer>> getTestCase2() {
		List<List<Integer>> result = new ArrayList<>();
		result.add(Arrays.stream(new int[] {1,0,0,0,0}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,1,0,0,0}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,0,1,0,0}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,0,0,1,0}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,0,0,0,1}).boxed().collect(Collectors.toList()));
		
		return result;
	}

	/*
	 * answer: 3
	 */
	public List<List<Integer>> getTestCase3() {
		List<List<Integer>> result = new ArrayList<>();
		result.add(Arrays.stream(new int[] {0,0,1,0,0,0}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,0,0,0,0,0}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,0,0,0,0,1}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,0,0,0,0,0}).boxed().collect(Collectors.toList()));
		result.add(Arrays.stream(new int[] {0,1,0,0,0,0}).boxed().collect(Collectors.toList()));
		
		return result;
	}

	public void run() {
		System.out.println(this.minimumHours(4, 5, getTestCase1()));
		System.out.println(this.minimumHours(5, 5, getTestCase2()));
		System.out.println(this.minimumHours(5, 6, getTestCase3()));
	}
	
	public static void main(String[] args) {
		new ServeFiles().run();
	}

}
