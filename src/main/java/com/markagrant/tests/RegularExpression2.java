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
                // zero length match
                if(j + 1 < pattern.length() && t == pattern.charAt(++j)) {
                    preceeding = t;
                    j++;
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
