import java.util.Scanner;

//exe7
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a valid quadratic equation");
        String quadraticEquation = scanner.nextLine();
        findingX(quadraticEquation);
    }

    public static void findingX(String quadratic) {
        int counter = 0;
        int a;
        int b;
        int c;
        char[] array = new char[11];
        if (quadratic.charAt(0) == 'x') {
            System.out.println("Please enter a coefficient for X.");
        }
        if (quadratic.length() == 11) {
            for (int i = 0; i < 11; i++) {
                array[i] = quadratic.charAt(i);
                if (array[i] <= '9' && array[i] >= '0') {
                    counter++;
                }
            }
            if (array[1] == 'x' && array[6] == 'x' && array[4] == '+' && array[7] == '+'
                    && array[9] == '=' && array[2] == '^' && array[3] == '2' && array[10] == '0'
                    && counter == 5) {
                // According to ASCII table
                a = array[0] - 48;
                b = array[5] - 48;
                c = array[8] - 48;
                equationSolution(a, b, c);
            } else {
                System.out.println("Invalid quadratic equation");
            }

        } else {
            System.out.println("Invalid quadratic equation");
        }
    }

    public static void equationSolution(int a, int b, int c) {
        double x1;
        double x2;
        double sum = Math.sqrt((b * b) - 4 * a * c);
        if (sum > 0) {
            x1 = (-b + sum) / 2 * a;
            x2 = (-b - sum) / 2 * a;
            System.out.println("Solution of X1 =" + " " + x1 + ", Solution of X2 =" + " " + x2);
        }
        if (sum == 0) {
            x1 = (-b / (2 * a));
            System.out.println("Solution of X = "+x1);
        } else if (sum < 0) {
            System.out.println("No solution to the equation");
        }
    }
}
