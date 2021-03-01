package amazon;

public class AmazonZombie2 {

	public int[][] setup() {
//		return new int[][] {
//			{2,1,0,0,0},
//			{2,0,2,2,0},
//			{1,2,0,0,0},
//			{0,2,0,0,0}
//		};

		return new int[][] {
			{2,0,0,0},
			{2,2,2,1},
			{0,0,2,2}
		};
	}
	
	public void printArray(int[][] dayZero) {
		for(int x=0;x<dayZero.length;x++) {
			for(int y=0;y<dayZero[x].length;y++) {
				System.out.println("x[" + x + "], y[" + y + "], value[" + dayZero[x][y] + "]");
			}			
		}
	}
	
	public int daysToCompleteInfection(int[][] day) {
		int[][] currentView = new int[day.length][day[0].length];

		boolean canProceed = true;
		
		int PriorNumberOfHumans = -1;
		int numberOfDays = 0;
		int numberOfHumans = 0;
		
		while ( canProceed ) {
			int numberOfZombies = 0;
			int numberOfWalls = 0;
			numberOfHumans = 0;
			
			for(int x=0;x<day.length;x++) {
				for(int y=0;y<day[x].length;y++) {
						
					if ( day[x][y] == 0 ) {
						numberOfHumans++;
					} else if ( day[x][y] == 1 ) {
						numberOfZombies++;
	
						boolean left = ( y-1 >= 0 );
						boolean right = ( y+1 < day[x].length);
						boolean bottom = ( x+1 < day.length );
						boolean top = ( x-1 >= 0 );
						
						if ( left && day[x][y-1] == 0 ) {
							currentView[x][y-1] = 1;
							numberOfZombies++;
							if ( numberOfHumans > 0 ) numberOfHumans--;
						}
						if ( right && day[x][y+1] == 0 ) {
							currentView[x][y+1] = 1;
							numberOfZombies++;
							if ( numberOfHumans > 0 ) numberOfHumans--;
						}
						if ( bottom && day[x+1][y] == 0 ) {
							currentView[x+1][y] = 1;
							numberOfZombies++;
							if ( numberOfHumans > 0 ) numberOfHumans--;
						}
						if ( top && day[x-1][y] == 0 ) {
							currentView[x-1][y] = 1;
							numberOfZombies++;
							if ( numberOfHumans > 0 ) numberOfHumans--;
						}
					
						currentView[x][y] = day[x][y];
					} else {
						numberOfWalls++;
						currentView[x][y] = day[x][y];
					}
				}
			}
			numberOfDays++;
			printArray(currentView);
			System.out.println("Number of zombies[" + numberOfZombies + "], humans[" + numberOfHumans + "], walls[" + numberOfWalls + "]");
			
			if ( numberOfHumans != 0 && PriorNumberOfHumans != numberOfHumans)  {
				PriorNumberOfHumans = numberOfHumans;				
				day = currentView;
				currentView = new int[day.length][day[0].length];
			} else
				canProceed = false;
			
		}		
		
		return numberOfHumans != 0 ? -1 : numberOfDays;
	}
	
	public void run() {
		System.out.println(daysToCompleteInfection(setup()));
	}
	
	public static void main(String[] args) {
		new AmazonZombie2().run();
	}
			
}
