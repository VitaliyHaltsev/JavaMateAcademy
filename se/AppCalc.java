package se;


public class AppCalc {
    public static void main(String[] args) {

        boolean startSession = true;

        do {
            Calculator calculator = new Calculator();

            //validate given expression
            String userInput = calculator.getExpression();
            String mathOperator = calculator.getMathOperator(userInput);


            if (userInput == null | CheckIn.isValid(userInput) == false) {
                System.out.println("Wrong input, please repeat.");
                    calculator.toContinue();
            } else {

                //check numerals are used (Arabic or Roman)
                if(!CheckIn.isArabic(userInput)) {
                    CheckIn.romanToArabic(userInput);
                }

                long[] operands = calculator.getOperands(userInput, mathOperator);
                calculator.calculate();
            }

        } while(startSession);
    }
}
