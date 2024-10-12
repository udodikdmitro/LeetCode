package main.stringtointeger;

public class Solution {
    private static final int MAX_INT = 2147483647;
    private static final int MIN_INT = -2147483648;
    public int myAtoi(String s) {
        StringBuilder resultSb = new StringBuilder();
        boolean isNegative = false;

        for (int i = 0; i < s.length(); i++) {
            char charString = s.charAt(i);
            char nextCharString = 0;

            nextCharString = getNextCharString(s, i, nextCharString);

            int x = checkingChar(charString, nextCharString);
            if (x == 0) return x;

            if (Character.isDigit(charString)) {
                int counter = 0;
                boolean charIsDigit;

                while ((i + counter) < s.length() && s.charAt(i + counter) == '0') {
                    counter++;
                }

                if (s.charAt(s.length() - 1) == '0' && counter > 0) counter--;

                charIsDigit = Character.isDigit(s.charAt(i + counter));

                if (!charIsDigit) {return 0;}

                concatenateIntString(s, i, counter, resultSb);
                isNegative = i != 0 && s.charAt(i - 1) == '-';
                break;
            }
        }

        return getInteger(resultSb, isNegative);
    }

    private static Integer checkingChar(char firstChar, char nextChar) {
        if (!Character.isDigit(firstChar) && firstChar != ' '
                && firstChar != '-' && firstChar != '+') {
            return 0;
        } else if ((firstChar == '-' || firstChar == '+') && !Character.isDigit(nextChar)) {
            return 0;
        } else
            return 1;
    }

    private static char getNextCharString(String string, int index, char nextChar) {
        if (index < string.length() - 1) {
            nextChar = string.charAt(index + 1);
        }
        return nextChar;
    }

    private static void concatenateIntString(String s, int startPos, int counterDigits, StringBuilder sb) {
        while ((startPos + counterDigits) < s.length() && Character.isDigit(s.charAt(startPos + counterDigits))) {
            sb.append(s.charAt(startPos + counterDigits));
            counterDigits++;
        }
    }

    private static int getInteger(StringBuilder resultSb, boolean isNegative) {
        String resultStr = resultSb.toString();

        if (resultStr.length() > 10 && !isNegative) return MAX_INT;
        if (resultStr.length() > 10 && isNegative) return MIN_INT;
        long resultB = 0;

        for (int i = 0; i < resultStr.length(); i++) {
            long digit = (long)((resultStr.charAt(i) - '0') * (Math.pow(10, (resultStr.length() - 1 - i))));
            resultB += digit;
        }

        if (isNegative) {resultB = resultB * (-1);}
        if (resultB > MAX_INT) {return MAX_INT;}
        if (resultB < MIN_INT) {return MIN_INT;}
        return (int) resultB;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("042"));
        System.out.println(s.myAtoi(" -042"));
        System.out.println(s.myAtoi("1337c0d3"));
        System.out.println(s.myAtoi("0-1"));
        System.out.println(s.myAtoi("words and 987"));
        System.out.println(s.myAtoi("-91283472332"));
        System.out.println(s.myAtoi(".1"));
        System.out.println(s.myAtoi("000000000000000"));
        System.out.println(s.myAtoi("21474836460"));
        System.out.println(s.myAtoi("9223372036854775808"));
    }
}