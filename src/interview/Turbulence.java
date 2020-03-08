package interview;

public class Turbulence {

	public int process(int[] data) {
		if (data == null || data.length == 0) return 0;
		if (data.length == 1) return 1;
		
		boolean priorNegative = false;
		boolean firstTime = true;
		
		int maxTurbulenceSize = 2;
		int currentSize = 1;

		for(int i=0;i<data.length-1;i++) {
			int sum = data[i] - data[i+1];
			if (firstTime) {
				firstTime = false;
				if (sum > 0) {
					priorNegative = false;
					currentSize++;
				} else if (sum < 0) {
					priorNegative = true;
					currentSize++;
				} else {}
				
				continue;
			}
			
			if (sum < 0) {
				if (priorNegative) {
					if (currentSize > maxTurbulenceSize) {						
						maxTurbulenceSize = currentSize;
					} 
					currentSize = 0;
				} else {
					currentSize++;
				}
				priorNegative = true;
			} else if (sum > 0) {
				if (priorNegative) {
					currentSize++;
				} else {
					if (currentSize > maxTurbulenceSize) {						
						maxTurbulenceSize = currentSize;
					}
					currentSize = 0;
				}
				priorNegative = false;
			} else {
			}
		}
		if (currentSize > maxTurbulenceSize) {						
			maxTurbulenceSize = currentSize;
		} 
		
		return maxTurbulenceSize;
	}	
	
	public static void main(String[] args) {
		int[] data = new int[100000];
		for(int i=0;i<100000;i++) {
			if (i%2==0)
				data[i]=50;
			else
				data[i]=100;
		}
		
		System.out.println((new Turbulence()).process(data));
	}
}
