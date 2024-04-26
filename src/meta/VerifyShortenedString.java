package meta;

import java.io.*;
import java.util.*;

public class VerifyShortenedString {
  // i18n - internationalization
  // f6k - facebook
  // f7 - facebook
  // 8 - facebook
  // f2eb2k - facebook

  // INVALID:
  // f6k - faceboook
  // f6k - focus

  // str = a, shortStr = 1

  public boolean validate(String str, String shortStr) {
    System.out.print(str + "," + shortStr + " ");

    int i = 0;
    int j = 0;

    StringBuffer sb = new StringBuffer();
    while (i < str.length() && j < shortStr.length()) {
      if (sb.length() != 0 && !Character.isDigit(shortStr.charAt(j))) {        
        i += Integer.valueOf(sb.toString());
        sb = new StringBuffer();
      } else if (str.charAt(i) == shortStr.charAt(j)) {
        ++i;
        ++j;
      } else if (Character.isDigit(shortStr.charAt(j))) {
        sb.append(Character.toString(shortStr.charAt(j)));
        ++j;
      } else if (!Character.isDigit(shortStr.charAt(j)) &&
          !Character.isDigit(str.charAt(i)) &&
          shortStr.charAt(j) != str.charAt(i)) {
        return false;
      }
    }

    if (sb.length() != 0)
      i += Integer.valueOf(sb.toString());
     
    if (i == str.length() && j == shortStr.length())
      return true;

    return false;
  }

  public static void main(String[] args) {
    VerifyShortenedString app = new VerifyShortenedString();
    System.out.println("true==" + app.validate("internationalization", "i18n"));
    System.out.println("true==" + app.validate("facebook", "f6k"));
    System.out.println("true==" + app.validate("facebook", "f7"));
    System.out.println("true==" + app.validate("facebook", "8"));
    System.out.println("true==" + app.validate("facebook", "f2eb2k"));
    System.out.println("false==" + app.validate("faceboook", "f6k"));
    System.out.println("false==" + app.validate("focus", "f6k"));
    System.out.println("true==" + app.validate("a", "1"));
  }
}

// i18n - internationalization
// f6k - facebook
// f7 - facebook
// 8 - facebook
// f2eb2k - facebook

// INVALID:
// f6k - faceboook
// f6k - focus

// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
// i n t e r n a t i o n a l i z a t i o n

// 0 1 2 3
// i 1 8 n