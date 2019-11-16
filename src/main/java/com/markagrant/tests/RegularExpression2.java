package com.markagrant.tests;

public class RegularExpression2 {
    public boolean isMatch(String text, String pattern) {
        int j = 0;

        char preceeding = '$';
        for(int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);

            if(j == pattern.length())
                return false;

            char p = pattern.charAt(j);

            if(p == '.') {
                j++;
                preceeding = '.';
                continue;
            }

            if(p == '*') {
                if(t == preceeding)
                    continue;
                if(preceeding == '.' )
                    continue;
                // zero length match - try next char
                j++;
                if(j == pattern.length())
                    return false;
                if(pattern.charAt(j) == '.') {
                    j++;
                    preceeding = '.';
                    continue;
                }

                if(t == pattern.charAt(j)) {
                    j++;
                    preceeding = t;
                    continue;
                }

                return false;
            }

            if(p != t)
                return false;

            preceeding = t;
            j++;
        }
        return true;
    }
}
