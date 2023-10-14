package amazon._20231011;

public class countNumWays {
    
    public static int countNumWays(String s, int k) {
        if (k > s.length()) return 0;

        int count=0;

        for(int i=0; i< s.length(); i++) {
            if (!((i+k) > s.length())) {
                String org = s.substring(i, i+k);
                StringBuilder reverse = new StringBuilder(org);
                reverse.reverse();
                if (org.compareTo(reverse.toString()) > 0) {
                    count++;
                } else 
                    System.out.println(s + ";" + org + ";" + reverse);
            }
        }

        // Write your code here
        return count;
    }


    public static void main(String[] args) {
        System.out.println(countNumWays.countNumWays("aabbajbaa", 4));
//        System.out.println(Test3.countNumWays("aaaa", 4));
    }    

}
