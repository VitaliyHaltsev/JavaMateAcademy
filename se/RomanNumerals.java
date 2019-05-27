package se;



public enum RomanNumerals {
    _1("I", "", "", ""),
    _2("I", "I", "", ""),
    _3("I", "I", "I", ""),
    _4("I", "V", "", ""),
    _5("5", "", "", ""),
    _6("V", "I", "", ""),
    _7("V", "I","I", ""),
    _8("V", "I", "I","I"),
    _9("I", "X", "", ""),
    _10("X", "", "", "");

    private String firstSym, secondSym, thirdSym, fourSym ;

    RomanNumerals(String a, String b, String c, String d) {
        firstSym = a;
        secondSym = b;
        thirdSym = c;
        fourSym = d;
    }

    public String getValue() {
        return String.format("%s%s%s%s", firstSym, secondSym, thirdSym, fourSym);
    }

}
