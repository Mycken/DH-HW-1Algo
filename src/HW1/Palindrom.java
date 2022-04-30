package HW1;

import java.util.stream.IntStream;

public class Palindrom {
    public static void main(String[] args) {
        String[] isPalindrom = new String[]{"а роза упала на лапу азора", "ждфал полды пдпдлв ооал",
                "111 111 ааа ААА 111 111", "A man, a plan, a canal: Panama"};

        for (String t : isPalindrom) {
            System.out.println("Expression: " + t + " is palindrom? -" + isPalindromeUsingIntStream(t));
        }

    }


    public static boolean isPalindromeUsingIntStream(String text) {
        String temp = text.replaceAll("[^\\\\da-zA-Zа-яёА-ЯЁ]", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }

}
