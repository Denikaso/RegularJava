package org.example;

import java.util.regex.Pattern;

public class RegularJava {
    private static String patternIP = "(((25[0-5]|2[0-4]\\d|[01]?\\d{1,2})\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d{1,2}))";
    public boolean correctIP(String ip){
        return Pattern.matches(patternIP, ip);
    }
}
