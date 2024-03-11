import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Ex2 {
    public static void main(String[] args) {
        Map<String,Double> variables = new HashMap<String,Double>();

  

        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            Scanner sc = new Scanner(input.nextLine());
            if (sc.hasNext()) {
                System.out.println("result = " + processExpression(sc));
            }
        }   
    }

    public static boolean isNumber(String token) {
        Scanner sc = new Scanner(token);
        boolean res = sc.hasNextDouble();
        sc.close();
        return res;
    }

    public static boolean isVar(String token) {
        boolean res = token != null && Character.isLetter(token.charAt(0));
        for (int i = 1; res && i < token.length(); i++) {
            res = Character.isLetterOrDigit(token.charAt(i)); 
        }
        return res;
        
    }

    public static int processExpression(Scanner sc) {
        double n1 = 0, res = 0;
        String input1 = sc.next();

        if (isVar(input1)) {
            if (variables.containsKey(input1)) {
                
            }
        } 

        return res;
    }
}

