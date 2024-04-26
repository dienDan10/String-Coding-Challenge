import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        challenge6Method2("programming", 'g');
    }

    /*
    * Challenge 1: Write a java program to reverse a String
    * input: hello
    * output: olleh
    * */

    // using toCharArray() method
    private static void challenge1Method1(String input) {
        char[] chars = input.toCharArray();
        String output = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            output = output + chars[i];
        }
        System.out.println("input: " + input);
        System.out.println("output: " + output);
    }

    // using charAt(int index) method
    private static void challenge1Method2(String input) {
        int lastIndex = input.length() - 1;
        String output = "";
        while (lastIndex >= 0) {
            output += input.charAt(lastIndex);
            lastIndex--;
        }
        System.out.println("input: " + input);
        System.out.println("output: " + output);
    }

    // using java.lang.StringBuffer class
    private static void challenge1Method3(String input) {
        StringBuffer sb = new StringBuffer(input);
        System.out.println("input: " + input);
        System.out.println("output: " + sb.reverse().toString());
    }

    // using java.lang.StringBuilder class
    private static void challenge1Method4(String input) {
        StringBuilder sb = new StringBuilder(input);
        System.out.println("input: " + input);
        System.out.println("output: " + sb.reverse().toString());
    }

    /*
    * Challenge 2: Write a java program to remove all special characters from a string
    * input: $ja!va$&st%ar
    * output: javastar
    * */

    // using replaceAll() method
    private static void challenge2Method1(String input) {
        String output = input.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("input: " + input);
        System.out.println("output: " + output);
    }

    /*
    *  Challenge 3: Write a java program to remove all white space from
    *  a given String
    *  Input: "  ja   va  st   ar  "
    *  Output: "javastar"
    * */

    // using replaceAll() method
    private static void challenge3Method1(String input) {
        String output = input.replaceAll("\\s", "");
        System.out.println("input: " + input);
        System.out.println("output: " + output);
    }

    /*
    * Challenge 4: Remove duplicate characters in a given String
    * Input: programming
    * Output: poraming
    * */

    // using traditional loop method
    // O = nlogn -> not a wise choice
    private static void challenge4Method1(String input) {
        char[] chars = input.toCharArray();
        String output = "";
        for (int i = 0; i < chars.length; i++) {
            boolean isDuplicated = false;
            for (int j = i - 1; j >= 0; j--) {
                if (chars[i] == chars[j]) {
                    isDuplicated = true;
                }
            }
            if (!isDuplicated) {
                output += chars[i];
            }
        }
        System.out.println("input: " + input);
        System.out.println("output: " + output);
    }

    // using Set Data structure
    private static void challenge4Method2(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!set.contains(input.charAt(i))) {
                set.add(input.charAt(i));
            }
        }
        String output = set.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }

    // using StringBuilder with stream
    private static void challenge4Method3(String input) {
        StringBuilder res = new StringBuilder();
        input.chars().distinct().forEach(i -> res.append((char) i));
        System.out.println("input: " + input);
        System.out.println("output: " + res);
    }

    /*
    * Challenge 5: Sort String characters in alphabetical orders
    * input: programming
    * output: aggimmnoprr
    * */

    // using sort method
    private static void challenge5Method1(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        String output = String.valueOf(chars);
        System.out.println("input: " + input);
        System.out.println("output: " + output);
    }


    /*
    *  Challenge 6: Replace character with its occurrence in String
    *  Input: (String "programming", char g)
    *  Output: prog1rammin2
    * */

    // using toCharArray() method
    private static void challenge6Method1(String input, char c) {
        int count = 1;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                chars[i] = Character.forDigit(count, 10);
                count++;
            }
        }
        String output = String.valueOf(chars);
        System.out.println("input: " + input);
        System.out.println("output: " + output);
    }

    // using replaceFirst() method
    private static void challenge6Method2(String input, char c) {
        int count = 1;
        String output = input;
        while (output.indexOf(c) != -1) {
            output = output.replaceFirst(String.valueOf(c), String.valueOf(count));
            count++;
        }
        System.out.println("input: " + input);
        System.out.println("output: " + output);
    }
}