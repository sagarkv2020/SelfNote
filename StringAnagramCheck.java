package acn;

import java.util.Arrays;

public class StringAnagramCheck {
    public static void main(String[] args) {
        String s1 = "sagar";
        String s2 = "sgaar";

        Boolean isReverse = checkReverse(s1, s2);
        System.out.println("Are S1 and S2 reverse of each other : " + isReverse);

        Boolean isAnagram = checkAnagram(s1, s2);
        System.out.println("Are S1 and S2 Anagrams : " + isAnagram);
        System.out.println("More Optimal Anagram check : " + isAnagramOptimal(s1,s2));
    }

    private static boolean  isAnagramOptimal(String s1, String s2) {
        if (s1.length() != s2.length()) return false; // Quick fail if lengths differ

        int[] count = new int[256]; // For all ASCII characters

        // Count +1 for every character in s1
        // Count -1 for every character in s2
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        // After this, if all values are zero, strings are anagrams
        for (int c : count) {
            if (c != 0) return false; // Not an anagram
        }

        return true; // It's an anagram
    }

    private static Boolean checkAnagram(String s1, String s2) {
        String s1Sorted = sort(s1);
        String s2Sorted = sort(s2);
        return s1Sorted.equalsIgnoreCase(s2Sorted);

    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static Boolean checkReverse(String s1, String s2) {
        return s1.equalsIgnoreCase(new StringBuilder(s2).reverse().toString());
    }

}
