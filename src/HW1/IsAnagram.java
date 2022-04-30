package HW1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsAnagram {
    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagram_1(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        } else {
            int [] sArray = s.chars().sorted().toArray();
            int [] tArray = t.chars().sorted().toArray();

            for (int i = 0; i < sArray.length; i++){
                if (sArray[i] != tArray[i]) return false;
            }
        }
        return true;
    }
    public static boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        List<Character> sArray = s.chars().mapToObj( ch -> new Character((char)ch)).collect(Collectors.toList());
        List<Character> tArray = t.chars().mapToObj(ch -> new Character((char)ch)).collect(Collectors.toList());
        for (int i = 0; i < s.length(); i++){
            if (tArray.contains(sArray.get(i))){
                tArray.set(tArray.indexOf(sArray.get(i)),'0');
            }
        }


        return tArray.stream().mapToInt(c -> (int) c.charValue())
                .filter(x -> x != 48)
                .sum() == 0;

//        return  (t.length() == 0);
//
//        for (int i = 0; i < s.length(); i++){
//            if (!t.contains(String.valueOf(s.charAt(i)))){
//                return false;
//            }
//        }

//        return  !(s + t).chars().mapToObj( ch -> new Character( (char)ch ) )
//                .collect(Collectors.groupingBy( Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .map(entry -> entry.getValue() % 2 )
//                .anyMatch(x ->x == 1);

    }
}
