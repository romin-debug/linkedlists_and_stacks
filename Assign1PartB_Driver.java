package Assignment1;



/*
* Romin Patel
* 3164066
* Assignment-1
* ACS-2947
*/
 
import java.util.Scanner;
public class Assign1PartB_Driver {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.println("Simple Calculator : type z to undo, y to redo, q to quit");
        while(true){
            System.out.println("Enter the first number (or 'q' to quit): ");
            String input = kb.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                int initialNumber = Integer.parseInt(input);
                calc.operations('+', initialNumber);

                while (true) {
                    System.out.print("Enter the next operation on " + calc.getResult() + ": ");
                    input = kb.nextLine();

                    if (input.equalsIgnoreCase("q")) {
                        System.out.println("Goodbye!");
                        return;
                    } else if (input.equalsIgnoreCase("z")) {
                        calc.undoOperation();
                    } else if (input.equalsIgnoreCase("y")) {
                        calc.redoOperation();
                    } else {
                        char operator = input.charAt(0);
                        int operand = Integer.parseInt(input.substring(1));
                        calc.operations(operator, operand);
                        System.out.println("= " + calc.getResult());
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
