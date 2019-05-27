package se;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculator {

    String currentExpression;
    String mathOperator;
    long[] operands;
    Scanner scanner;


    Calculator() {
        System.out.println("Start\n");
        setExpression();
    }


    private void setExpression() {
        System.out.print("Input math expression use Arabian or Romans numerals: \n");
        scanner = new Scanner(System.in);
        currentExpression = scanner.nextLine();

    }


    public String getExpression() {
        return currentExpression;
    }


    public String getMathOperator(String currentExpression) {
        mathOperator = currentExpression.replaceAll("[^\\/,\\+,\\-,\\*]", "");
        return mathOperator;
    }


    public long[] getOperands (String currentExpression, String mathOperator) {
        operands = new long[mathOperator.length() + 1];

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(currentExpression);

        int count = 0;
        while (matcher.find()){
            operands[count] = Integer.parseInt(matcher.group());
            count++;
        }
        return operands;
    }


    //calculate expression
    void calculate() throws ArithmeticException, IndexOutOfBoundsException {

       try {
           switch (mathOperator) {
               case "+":
                   System.out.println("Result is " + Math.addExact(operands[0], operands[1]));
                   break;

               case "-":
                   System.out.println("Result is " + Math.subtractExact(operands[0], operands[1]));
                   break;

               case "*":
                   System.out.println("Result is " + Math.multiplyExact(operands[0], operands[1]));
                   break;

               case "/":
                   System.out.println("Result is " + Math.floorDiv(operands[0], operands[1]));
           }

       } catch (ArithmeticException exception) {
           System.out.println("You can't divide by zero!\n");
       } catch (IndexOutOfBoundsException exception) {
           System.out.println("Something went wrong with I/O arguments");
       }finally {
           toContinue();
       }
    }



    protected boolean toContinue() {
        System.out.println("\n-----------------------\n" +
                "To Continue press 'Enter'\n" + "to Quit press 'q'\n");
        String doContinue = scanner.nextLine();

        if ("q".equals(doContinue)) {
            System.out.println("Session Terminate!\n" + "--------------------------\n");
            System.exit(0);
        }
        boolean nextSession = true;
        return nextSession;
    }
}
