package capitalone;

/*

Four coding questions. 70 minute time.

1. 2 equal length strings. Check that each char of first string is one less than second string.  if char == 'z' then second string char == 'a'
2. 4 string lists.  reviews. pos words, neg words, heighten words.  heighten word increases next neg or pos word.  determine if reviews are pos, neg or neutral
3. List with start times. A task takes 300 seconds to complete.  Start time gets queued.  Return each start time's completion time.
4. List of strings. Compare each string with all other strings. Increase count if str A starts with str B or vice versa.

 */

import java.util.*;

public class Assessment {

    public boolean Q1(String first, String two) {
        char[] f = first.toCharArray();
        char[] s = two.toCharArray();

        boolean result = true;
        for(int i=0; i<first.length(); i++) {
            if (!((f[i]+1 == s[i]) || (f[i] == 'z' && s[i] == 'a')))
                result = false;
        }

        return result;
    }

    public List<String> Q2(String[] reviews, String[] pWords, String[] nWords, String[] iWords) {
        List<String> result = new ArrayList<>();
        int nWord = 0;
        int pWord = 0;
        int iWord = 0;

        for(String review : reviews) {
            String[] tokens = review.split(" ");
            for(String token : tokens) {
                if (Arrays.binarySearch(iWords, token) >= 0) 
                    iWord++;
                if (Arrays.binarySearch(nWords, token) >= 0) {
                    nWord += iWord + 1;
                    iWord = 0;
                }
                if (Arrays.binarySearch(pWords, token) >= 0) {
                    pWord += iWord + 1;
                    iWord = 0;
                }
            }
            System.out.println("nWord=" + nWord + ", pWord=" + pWord);
            if (nWord == pWord) result.add("neutral");
            if (nWord > pWord) result.add("negative");
            if (nWord < pWord) result.add("positive");
        }

        return result;
    }

    public List<Integer> Q3(List<Integer> startTime) {
        List<Integer> result = new ArrayList<>();

        int priorTime = 0;
        for(Integer currTime : startTime) {
            int endTime = currTime + 300 + (priorTime - currTime < 0 ? 0 : priorTime - currTime);
            result.add(endTime);
            priorTime = endTime;
        }

        return result;
    }

    public int Q4(String[] strList) {

        int result = 0;
        Arrays.sort(strList);

        for(int i=0; i<strList.length; i++) {
            for(int j=i+1; j<strList.length; j++) {
                System.out.println(strList[i] + ":" + strList[j]);
                if (strList[i].startsWith(strList[j]) || strList[j].startsWith(strList[i]))
                    result++;
                else 
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Assessment app = new Assessment();
        System.out.println(app.Q1("abz", "bcb"));
        // System.out.println(app.Q2(new String[]{"very bad but good good good"}, new String[]{"good"}, new String[]{"bad"}, new String[]{"very"}));
        // System.out.println(app.Q3(List.of(4,400,401,402,403,500)));
        // System.out.println(app.Q4(new String[]{"a", "ab", "abc", "a", "b", "d"}));        
    }
}
