package meta;

public class RotaryLock2 {

    public boolean test() {

        maxVal = -1;
        ones = 0;
        twos = 0 
        isOne = False;
        
        for i in S: 
            maxVal = max(maxVal, i) 
            if i%3 == 1: 
                ones = 1 
            if i%3 == 2: 
                twos = 1 
            if i == 1: 
                isOne = True 
            if ones and twos and not isOne and maxVal % 3 == 1: 
                return ones + twos + maxVal 
                
            // 3 - 1 elif ones and twos and maxVal % 3 == 0: return ones + twos + maxVal 
            // 3 - 1 elif not ones and twos and maxVal % 3 == 1: return ones + twos + maxVal 
            // 3 - 1 else: return ones + twos + maxVal 
            // 3


        return false;        
    }


    public long getMinCodeEntryTime(int N, int M, int[] C) {
    
        long lock1=1;
        long lock2=1;
        long seconds=0;
        long Nlong = Long.valueOf(N);
        String nextDirection = null;
        boolean initFirstLock1=true;
        boolean initFirstLock2=true;
        
        for(int n : C) {
          long lock1secs=0;
          long lock2secs=0;
          long dest = Long.valueOf(n);
          
          if (dest < lock1) {
            long right=Nlong-lock1+dest;
            long left=lock1-dest;
            if (initFirstLock1) {
              if (left < right) {
                nextDirection = "R";
                lock1secs=left;  
              } else {
                nextDirection = "L";
                lock1secs=right;  
              }
              initFirstLock1=false;
            } else if (nextDirection.equals("R")) {
                nextDirection = "L";
                lock1secs=right;  
            } else {
                nextDirection = "R";
                lock1secs=left;  
            }
            //lock1secs=Math.min(right, left);
          } else {
            long right=dest-lock1;
            long left=Nlong-dest+lock1;
            if (initFirstLock1) {
              if (left < right) {
                nextDirection = "R";
                lock1secs=left;  
              } else {
                nextDirection = "L";
                lock1secs=right;  
              }
              initFirstLock1=false;
            } else if (nextDirection.equals("R")) {
                nextDirection = "L";
                lock1secs=right;  
            } else {
                nextDirection = "R";
                lock1secs=left;  
            }
    //        lock1secs=Math.min(right, left);
          }
    
          if (dest < lock2) {
            long right=Nlong-lock2+dest;
            long left=lock2-dest;
            if (initFirstLock2) {
              if (left < right) {
                nextDirection = "R";
                lock1secs=left;  
              } else {
                nextDirection = "L";
                lock1secs=right;  
              }
              initFirstLock2=false;
            } else if (nextDirection.equals("R")) {
                nextDirection = "L";
                lock1secs=right;  
            } else {
                nextDirection = "R";
                lock1secs=left;  
            }
    //        lock2secs=Math.min(right, left);
          } else {
            long right=dest-lock2;
            long left=Nlong-dest+lock2;
            if (initFirstLock2) {
              if (left < right) {
                nextDirection = "R";
                lock1secs=left;  
              } else {
                nextDirection = "L";
                lock1secs=right;  
              }
              initFirstLock2=false;
            } else if (nextDirection.equals("R")) {
                nextDirection = "L";
                lock1secs=right;  
            } else {
                nextDirection = "R";
                lock1secs=left;  
            }
    //        lock2secs=Math.min(right, left);
          }
          
          seconds += Math.min(lock1secs, lock2secs);
          if (lock1secs < lock2secs)
            lock1 = dest;
          else 
            lock2 = dest;
        }    
        return seconds;
      }
        


    public static void main(String[] args) {
        RotaryLock2 app = new RotaryLock2();
        System.out.println(app.getMinCodeEntryTime(3, 3, new int[]{1,2,3}));
        System.out.println(app.getMinCodeEntryTime(10, 4, new int[]{9,4,4,8}));
    }
}
