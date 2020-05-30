package com.tw;


import com.tw.utils.Alignment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeekFourTest {

    private StringsPart stringsPart = new StringsPart();

    @Test
    void should_iterate_string_put_in_array() {
        char[] result = stringsPart.stringToCharArray("book");
        char[] expected = {'b', 'o', 'o', 'k'};
        assertArrayEquals(expected, result);
    }

    @Test
    void should_iterate_string_put_in_intArray() {
        int[] expected = {1, 2, 3, 4, 5};
        int[] result = stringsPart.stringToIntArray("12345");
        assertArrayEquals(expected, result);
    }

    @Test
    void should_split_string() {
        String[] expected = {"a", "b", "c"};
        String[] result = stringsPart.stringsSplitToArray("a,b,c");
        assertArrayEquals(expected, result);
    }

    @Test
    void replace_character_to_character() {
        String origin = "abc def";
        String excepted = "bac def";
        String result = stringsPart.replaceCharacter(origin, 'a', 'b');
        assertEquals(result, excepted);
    }

    @Test
    void should_reverse_string() {
        String excepted = "CBA";
        String origin = "ABC";
        String result = stringsPart.reverseString(origin);
        assertEquals(result, excepted);
    }

    @Test
    void should_reverse_words() {
        String origin = "one Two Three";
        String excepted = "Three Two one";
        String result = stringsPart.replaceCharacter(origin,'a','b');
        assertEquals(result, excepted);
    }

    @Test
    void should_upper_first_letter_in_words() {
        String origin = "one Two three";
        String excepted = "One Two Three";
        String result = stringsPart.upperLetterInWords(origin);
        assertEquals(excepted, result);
    }

    @Test
    void should_align_to_left_or_right(){
        String excepted = "         a";
        assertEquals(excepted,stringsPart.align_string_left_or_right("a",10, Alignment.RIGHT));
    }

    @Test
    void should_matches_mobilePhoneNumber(){
        assertTrue(stringsPart.isMatchPhoneNumber("+86 187 1075 6205"));
    }

    void should_convert_string_to_int_double(){
        
    }



}
