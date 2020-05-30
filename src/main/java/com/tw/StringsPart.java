package com.tw;


import com.tw.utils.Alignment;

import java.util.regex.Pattern;


/**
 * @author hujia
 */
public class StringsPart {

    public char[] stringToCharArray(String str) {
        return str.toCharArray();
    }

    public int[] stringToIntArray(String str) {
        char[] chars = str.toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i] - '0';
        }
        return result;
    }

    public String[] stringsSplitToArray(String str) {
        return str.split(",");
    }

    public String replaceCharacter(String string, char from, char to) {
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == from) {
                chars[i] = to;
            } else if (chars[i] == to) {
                chars[i] = from;
            }
        }
        return new String(chars);
    }

    public String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public String reverseWord(String string) {
        String[] words = string.split(" ");
        StringBuilder ReverseWords = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            ReverseWords.append(words[i]);
            if (i > 0) {
                ReverseWords.append(" ");
            }
        }
        return ReverseWords.toString();
    }

    public String upperLetterInWords(String string) {
        String[] words = string.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            char first_letter = Character.toUpperCase(words[i].charAt(0));
            StringBuilder tmp = new StringBuilder(words[i]).replace(0, 1, String.valueOf(first_letter));
            result.append(tmp);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }


    public String align_string_left_or_right(String input, int maxSize, Alignment alignment) {
        int padSize = maxSize - input.length();
        StringBuilder result = new StringBuilder();

        switch (alignment) {
            case LEFT:
                result.append(input);
                pad(result, padSize);
                break;
            case CENTER:
                pad(result, padSize / 2);
                result.append(input);
                pad(result, padSize - padSize / 2);
                break;
            case RIGHT:
                pad(result, padSize);
                result.append(input);
                break;
            default:
        }

        return result.toString();
    }

    private void pad(StringBuilder stringBuilder, int cnt) {
        for (int i = 0; i < cnt; i++) {
            stringBuilder.append(" ");
        }
    }

    public boolean isMatchPhoneNumber(String input){

        String regex = "^(\\+86)\\s[1-9](\\d{2})\\s(\\d{4})\\s(\\d{4})$";
        return Pattern.matches(regex, input);
    }

}
