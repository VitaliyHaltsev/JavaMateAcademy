package se;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CheckIn {

    public static boolean isValid(String expression) {

        //find
//        Pattern pattern = Pattern.compile("((?=^.*\\d)(?=^.*[*\\-+/]))");
//        Pattern pattern = Pattern.compile("[0-9]");
//        String regex = "\\d\\s{0,1}\\D{0}[IVX]";
        String regex = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        return (matcher.find()) ? true : false;
    }


//    public static String getOperator(String mathExpression) {
//        String operand = mathExpression.replaceAll("[^\\/,\\+,\\-,\\*]", "");
//        return operand;
//    }


    public static boolean isArabic(String expression) {

//        String regexRom = "[A-Z&&[^IVX]]";
        String regexRom = "\\d";
        Pattern pattern = Pattern.compile(regexRom);
        Matcher matcher = pattern.matcher(expression);
        return (matcher.find()) ? true : false;
    }


    public static String romanToArabic(String userInput) {

        String strIn = userInput.replaceAll("[^I, V, X]", "");

        String[] romanNums = new String[strIn.length()];
        for (char input: strIn.toCharArray()) {
            for (int i = 0; i < romanNums.length; i++) {
                romanNums[i] = String.valueOf(input);
            }
        }

        
        //transformation Roman numerals to Arabic digits
        String[] storRomNums = new String[romanNums.length];
        for (int i = 0; i < romanNums.length; i++) {
            for (RomanNumerals key : RomanNumerals.values()) {
                if (key.getValue().equals(romanNums[i])) {
                    storRomNums[i] = key.name();
                }
            }

            storRomNums[i] = storRomNums[i].replaceAll("_", "");
        }

        strIn = Arrays.toString(storRomNums);

        System.out.println("Rom to Arab is - " + strIn);
        return strIn;
    }
}
