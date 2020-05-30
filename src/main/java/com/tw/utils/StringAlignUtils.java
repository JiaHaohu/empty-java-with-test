package com.tw.utils;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author hujia
 */
public class StringAlignUtils extends Format {

    private static final long serialVersionUID = 1L;

    public enum Alignment {
        LEFT, CENTER, RIGHT
    }

    private Alignment currentAlignment;

    private final int maxChars;

    public StringAlignUtils(int maxChars, Alignment alignment) {
        switch (alignment) {
            case LEFT:
            case CENTER:
            case RIGHT:
                this.currentAlignment = alignment;
                break;
            default:
                throw new IllegalArgumentException("invalid justification arg");
        }
        if (maxChars < 0) {
            throw new IllegalArgumentException("maxChars must be positive");
        }
        this.maxChars = maxChars;
    }


    @Override
    public StringBuffer format(Object input, StringBuffer where, FieldPosition ignore) {
        String s = input.toString();
        List<String> strings = splitInputString(s);
        ListIterator<String> stringListIterator = strings.listIterator();

        while (stringListIterator.hasNext()) {
            String wanted = stringListIterator.next();

            switch (currentAlignment){
                case CENTER:
                    int padSize = maxChars - wanted.length();
                    pad(where,padSize/2);
                    where.append(wanted);
                    pad(where,padSize - padSize/2);
                    break;
                case LEFT:
                    pad(where,maxChars - wanted.length());
                    where.append(wanted);
                    break;
                case RIGHT:
                    where.append(wanted);
                    pad(where,maxChars-wanted.length());
                    break;
            }
            where.append("\n");
        }
        return where;
    }

    public String format(String s){
        return format(s,new StringBuffer(), null).toString();
    }

    private void pad(StringBuffer where, int padSize) {
        for (int i = 0; i < padSize; i++) {
            where.append(" ");
        }
    }

    @Override
    public Object parseObject(String source, ParsePosition pos) {
        return null;
    }

    private List<String> splitInputString(String str) {
        List<String> list = new ArrayList<>();
        if (str == null) {
            return list;
        }
        for (int i = 0; i < str.length(); i += maxChars) {
            int endIndex = Math.min(i + maxChars, str.length());
            list.add(str.substring(i, endIndex));
        }
        return list;
    }
}

