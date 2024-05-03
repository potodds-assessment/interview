package ubs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> run(String[] blacklistIPs, String[] IPs) {

        List<Integer> result = new ArrayList<>();
        Deque<String> fiveSecQ = new ArrayDeque<>();

        for(String ip : IPs) {
            boolean found=false;
            for(String blIP : blacklistIPs) {
                Pattern pattern = Pattern.compile(blIP);
                Matcher matcher = pattern.matcher(ip);
                if (matcher.matches()) {
                    System.out.println("regex:" + blIP + ",ip:" + ip);
                    found=true;
                    break;
                }
            }
            if (found) {
                result.add(1);
                if (fiveSecQ.size() >= 5) {
                    fiveSecQ.removeLast();
                }
                fiveSecQ.addFirst(ip);

            } else {
                if (fiveSecQ.size() >= 5) {
                    if (fiveSecQ.contains(ip)) {
                        result.add(1);
                    } else {
                        result.add(0);
                    }

                    fiveSecQ.removeLast();
                    fiveSecQ.addFirst(ip);
                } else {
                    fiveSecQ.addFirst(ip);
                    result.add(0);
                }
            }


        }

        return result;
    }

    public void test() {
        String regex = "34.*";
        String ip = "12.1.23.34";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) 
            System.out.println("matches regex=" + regex + ",ip=" + ip);
        if (matcher.find()) 
            System.out.println("find regex=" + regex + ",ip=" + ip);
    }

    public static void main(String[] args) {
        BlackListIPs app = new BlackListIPs();
        System.out.println(app.run(new String[]{"111.*" , "123.*" , "34.*"}, 
            new String[]{"123.1.23.34", "121.1.23.34", "34.1.23.34", "12.1.23.34","121.1.23.34","121.1.23.34"}));
        app.test();
    }
}


