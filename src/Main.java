import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        challenge11Method1("onetwominussevenplustwosix"); // 12 - 7 + 26
        challenge11Method1("sevenminusonezero");
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

    /*
    * Challenge 7: Find first Non-repeated char in a given string
    * Input: AABCDBECF
    * Output: D
    * */

    // Using Collections
    private static void challenge7Method1(String input) {
        System.out.println("input: " + input);
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), 1);
            } else {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }
        }

        char c = '\u0000'; // default value for char
        for (int i = 0; i < input.length(); i++) {
            if (map.get(input.charAt(i)) == 1) {
                c = input.charAt(i);
                break;
            }
        }
        if (c == '\u0000') {
            System.out.println("No non repeated character.");
        }
        System.out.println("Output: " + c);
    }

    // without using collection
    private static void challenge7Method2(String input) {
        // A = 65, Z = 90, a = 97, z = 122
        int[] arr = new int[128];
        for (int i = 0; i < input.length(); i++) {
            arr[(int)input.charAt(i)]++;
        }
        char c = '\u0000';
        for (int i = 1; i < 128; i++) {
            if (arr[i] == 1) {
                c = (char) i;
                break;
            }
        }
        if (c == '\u0000') {
            System.out.println("No non repeated character.");
        }
        System.out.println("input: " + input);
        System.out.println("Output: " + c);
    }

    /*
    * Challenge 8: Find occurrence of each character in a given string
    * Input: hello
    * Output: h-1 e-1 l-2 o-1
    * */

    // using Map<> data structure
    private static void challenge8Method1(String input) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            map.merge(input.charAt(i), 1, Integer::sum);
        }
        System.out.println("Input: " + input);
        System.out.print("Output: ");
        map.forEach((key, value) -> {
            System.out.print(key + "-" + value + " ");
        });
        System.out.println();
    }

    // not using collections
    private static void challenge8Method2(String input) {
        System.out.println("Input: " + input);
        int[] arr = new int[128];
        for (int i = 0; i < input.length(); i++) {
            arr[(int)input.charAt(i)]++;
        }
        System.out.print("Output: ");
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (arr[(int)c] != 0) {
                System.out.print(c + "-" + arr[(int)c] + " ");
                arr[(int)c] = 0;
            }
        }
    }

    /*
    * Challenge 9: Write a java program to reverse each word in a given string
    * Input: java code
    * Output: avaj edoc
    * */

    private static void challenge9Method1 (String input) {
        String[] arr = input.split("\\s");
        StringBuilder res = new StringBuilder();
        for (String s : arr) {
            res.append(new StringBuilder(s).reverse());
            res.append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        System.out.println("Input: " + input);
        System.out.println("Output: " + res);
    }

    /*
    * Challenge 10: Write a Java program to find longest substring without
    * repeating character
    * Input: abbac
    * Output: bac --> length is 3
    * */

    // Using Map<> data structure
    private static void challenge10Method1 (String input) {
        int length = 0;
        String output = null;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                i = map.get(c);
                map.clear();
            }
            if (map.size() > length) {
                length = map.size();
                output = map.keySet().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Output: " + output + " --> Length is " + length);
    }

    // using traditional loop method
    private static void challenge10Method2 (String input) {
        int length = 0;
        int firstIndex = 0;
        int stringBeginning = 0;
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= stringBeginning; j--) {
                if (arr[i] == arr[j]) { //reset i and stringBeginning
                    i = j;
                    stringBeginning = j + 1;
                    break;
                }
            }

            if ((i - stringBeginning + 1) > length) { // update length and firstIndex
                length = i - stringBeginning + 1;
                firstIndex = stringBeginning;
            }
        }
        System.out.println("Input: " + input);
        System.out.println("Output: " + input.substring(firstIndex, firstIndex + length) + " --> Length is " + length);
    }

    /*
    * Challenge 11: Write a Java program to calculate a Calculation written in string
    * Input: "onetwominussevenplustwosix"
    * Output: "threeone"
    * Note: if the result is negative -> "negativethreeone"
    * */

    private static void challenge11Method1 (String input) {
        // check for the first sign
        boolean isPlus = true;
        // create an array to map to number
        String[] nums = new String[] {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };

       String s = input;
       int res = 0;
       int temp = 0;
        while (!s.isEmpty()) {
           for (int i = 0; i < nums.length; i++) {
               if (s.startsWith(nums[i])) {
                   temp = temp * 10 + i;
                   s = s.substring(nums[i].length());
                   break;
               } else if (s.startsWith("plus")) {
                   res = isPlus ? res + temp : res - temp;
                   s = s.substring(4);
                   isPlus = true;
                   temp = 0;
                   break;
               } else if (s.startsWith("minus")){
                   res = isPlus ? res + temp : res - temp;
                   s = s.substring(5);
                   isPlus = false;
                   temp = 0;
               }
           }
        }
        res = isPlus ? res + temp : res - temp;
        StringBuilder output = new StringBuilder();
        if (res < 0) {
            output.append("negative");
            res = Math.abs(res);
        }
        for (int i = 0; i < (res + "").length(); i++) {
            output.append(nums[(res + "").charAt(i) - '0']);
        }
        System.out.println("res = " + output.toString());

    }

}
