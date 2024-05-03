package ubs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 there are n blacklisted ip regexes given as an array of strings, it consists of * or '.' 
 eg: *.123.* mathces with "12.1.123.45" , "1.123.435.12", but not with "1.2.3.4". 
 There are 'q' IP requests to be processed given as an array of IP address A request is blocked 
 if it matches with any blacklisted regex ip or IP address that has sent at least 2 requests in the last 5 seconds 
 which is not blocked return 1 if it will be blocked else 0 eg: blacklist =["*111.*" , "123.*" , "34.*"] 
 q = 7 requests = ["123.1.23.34", "121.1.23.34", "121.1.23.34", "34.1.23.34","121.1.23.34", "12.1.23.34", "121.1.23.34"] 
 output: [1,0,0,1,1,0,0]
 */

public class BlackListIPs {

    public void run() {

        String regex = ".123.*";
        String good = "12.1.123.45";
        String bad = "1.2.3.4";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(good);
        if (matcher.find())
            System.out.println(good + " worked");
        else
            System.out.println(good + " failed");

        matcher = pattern.matcher(bad);
        if (matcher.find())
            System.out.println(bad + " worked");
        else
            System.out.println(bad + " failed");

    }


    public static void main(String[] args) {
        BlackListIPs app = new BlackListIPs();
        app.run();
    }
}


