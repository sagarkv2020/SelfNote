package acn;

import java.util.*;
import java.util.stream.*;

public class StringReverse {

    public static void main(String[] args) {
        String input = "The   sky   is   blue  ";
        String result = reverseWords(input);
        System.out.println("Reversed: \"" + result + "\"");

        String result1 = reverseWordsDirect(input);
        System.out.println("Reversed: \"" + result1 + "\"");
    }

    private static String reverseWordsDirect(String input) {
        return  Arrays.stream(input.trim().split("\\s+"))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),  // Collect to a list
                        list -> {             // then reverse and join
                    Collections.reverse(list);
                    return String.join(" ", list);
                }));
    }

    private static String reverseWords(String input) {
        String[] words = input.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length -1;i>=0;i--){
            sb.append(words[i]);
             if(i != 0)sb.append(" ");
        }

    return sb.toString();
    }


}
