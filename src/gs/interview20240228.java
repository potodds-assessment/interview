package gs;

/* Problem Name is &&& Decimal Conversion &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 *    execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement addFractions() correctly.
 * 4) If time permits, try to improve your implementation.
 */

 public class interview20240228 {
    /**
     * Implement the method that provided numerator and denominator will return a string representing fraction's decimal form.
     * Some fractions in decimal form have cyclic decimal points.
     *
     * Examples:
     * 1/2 = 0.5
     * 1/3 = 0.(3)  0.33333333 
     * 9/11 = 0.(81) 0.8181818181
     */
    public static String vulgarToDecimal(long numerator, long denominator) {
      long part1 = numerator / denominator; //0
      long part2 = numerator % denominator; //1
        //1 * 10 
        //10 / 3 = 3 
        //10 % 3 = 0
        //1 * 10 = 10 
        //10 / 3 = 3
        //10 % 3 = 1
  
        //
  
      StringBuffer ans = new StringBuffer();
      ans.append(part1 + ".");
      ans.append(part2);
  
      return ans.toString();
    }
  
    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise false
     *
     * Consider adding more tests.
     */
    public static boolean doTestsPass() {
      boolean testsPassed = true;
  
      testsPassed &= vulgarToDecimal(1l, 2l).equals("0.5");
      testsPassed &= vulgarToDecimal(1l, 3l).equals("0.(3)");
  
      if(testsPassed) {
        System.out.println("Tests passes");
      } else {
        System.out.println("Tests failed");
      }
      return testsPassed;
    }
  
    public static void main(String[] args) {
      doTestsPass();
    }
  }