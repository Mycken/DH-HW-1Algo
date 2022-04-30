package HW1;

public class ReverseString {
    public static void main(String[] args) {
        char[] st = {'h', 'e', 'l', 'l', 'o'};
        reverseString(st);

        System.out.println(String.valueOf(st));
    }

    public static void reverseString(char[] s) {
        String line = String.valueOf(s);
        StringBuilder builder = new StringBuilder(line);
        line = builder.reverse().toString();
        char[] r = line.toCharArray();
        System.out.println(String.valueOf(r));
        System.arraycopy(r, 0, s, 0, r.length);
    }
}
