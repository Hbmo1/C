import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        double op1 = 0, op2 = 0, res = 0;
        String symbol = null;


        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your operation in the following format: num op num ");

        if (!sc.hasNextDouble()) {
            System.err.printf("ERROR: First input not a double. Exiting...\n");
            System.exit(1);
        } else {
            op1 = sc.nextDouble();
        }

        if (!sc.hasNext()) {
            System.err.printf("ERROR: Second input not a mathematical operation. Exiting...\n");
            System.exit(1);
        } else {
            symbol = sc.next();
        }

        if (!sc.hasNextDouble()) {
            System.err.printf("ERROR: Third input not a double. Exiting...\n");
            System.exit(1);
        } else {
            op2 = sc.nextDouble();
        }

        switch(symbol) {
            case "+":
                res = op1 + op2;
                System.out.println(op1 + " + " + op2 + " = " + res);
                break;

            case "-":
                res = op1 - op2;
                System.out.println(op1 + " - " + op2 + " = " + res);
                break;
            
            case "/":
                res = op1 / op2;
                System.out.println(op1 + " / " + op2 + " = " + res);
                break;

            case "*":
                res = op1 * op2;
                System.out.println(op1 + " * " + op2 + " = " + res);
                break;
            
            default:
                System.err.println("ERROR: Unexpected token inserted (only supports '+' '-' '/' '*')");
                System.exit(1);
        }       
    }
}
