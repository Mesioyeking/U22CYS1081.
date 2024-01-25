import java.util.Scanner;
public class twoDigitCalculator {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("A Calculator That performs Basic Operations Of Any Two Digit Number");

        //USER INPUTS FIRST VALID NUMBER FROM KEYBOARD
        System.out.print("Enter the first two digit number of your choice: ");
       double firstDigit = getValidDigitInput(scanner);

        //USER INPUTS A VALID OPERATOR FROM KEYBOARD
        System.out.print("Select the operation (+, -, *, /): ");
        char operation = getValidOperationInput(scanner);

        //USER INPUTS SECOND VALID NUMBER FROM KEYBOARD
        System.out.print("Enter the second two digit number of your choice: ");
       double secondDigit = getValidDigitInput(scanner);

        //DISPLAY RESULT
        double result = performOperation(firstDigit, secondDigit, operation);

        System.out.println("Result: " + result);

        scanner.close();
    }


    //CHECK FOR INVALID DIGITS
    private static double getValidDigitInput(Scanner scanner) {
        double digit;
        while (true) {
            try {
                digit = Integer.parseInt(scanner.nextLine());
                if (digit >= 0 && digit <= 99) {
                    break;
                } else {
                    System.out.println("Invalid input: Please enter a two digit number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid digit.");
            }
        }
        return digit;
    }


    //CHECK FOR INVALID OPERATOR
    private static char getValidOperationInput(Scanner scanner) {
        char operation;
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
                operation = input.charAt(0);
                break;
            } else {
                System.out.println("Invalid input: Please select a valid operation (+, -, *, /).");
            }
        }
        return operation;
    }


    //ARITHMETRIC OPERATION METHOD
    private static double performOperation(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    System.out.println("Error: Division by zero is undefined.");
                    System.exit(1);
                }
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
