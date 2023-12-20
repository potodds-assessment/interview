package amazon._20231215;

public class SkiMountain {
    int[][] gMountain;

    private int dfs(int row, int col, int prior) {
        if (row < 0 || col < 0 || row >= gMountain.length || col >= gMountain[0].length || gMountain[row][col] > prior)
            return 0;

        int top = dfs(row-1, col, gMountain[row][col]) + 1;        
        int bottom = dfs(row+1, col, gMountain[row][col]) + 1;
        int right = dfs(row, col+1, gMountain[row][col]) + 1;
        int left = dfs(row, col-1, gMountain[row][col]) + 1;

        return Math.max(Math.max(Math.max(top, bottom), right), left);
    }

    public int findLongest(int[][] mountain) {
        int maxValue=0;
        gMountain = mountain;

        for(int i=0; i<mountain.length; i++) {
            for(int j=0; j<mountain[0].length; j++) {
                maxValue = Math.max(dfs(i, j, Integer.MAX_VALUE), maxValue);
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        SkiMountain app = new SkiMountain();
        int[][] mountain = new int[][] {{1, 7, 8, 10}, {0, 5, 6, 3}, {2, 4, 9, 11}, {12, 15, 14, 16}};
        System.out.println(app.findLongest(mountain));
    }

}
