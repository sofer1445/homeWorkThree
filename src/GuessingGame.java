import java.util.Random;
import java.util.Scanner;

//Exe9
public class GuessingGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the guessing game");
        System.out.println("Dear user You are asked to enter a number with 4 digits");
        System.out.println("The number will contain numbers from 0 to 6, and will not be repeated");
        int[] arraySecretNumber = obtainingSecretCode();
        int route = levelSortingRoute();
        guessANumber(arraySecretNumber, route);


    }

    //Break down the number into indexes
    public static int[] decompositionOfNumber(int fullNumber) {
        Random random = new Random();
        int[] arrayNumber = new int[4];
        while (fullNumber < 123) {
            fullNumber = random.nextInt(6666);
        }
        if (fullNumber < 1000) {
            arrayNumber[0] = 0;
        }
        for (int i = 3; i >= 0; i--) {
            arrayNumber[i] = fullNumber % 10;
            fullNumber = fullNumber / 10;

        }
        return arrayNumber;
    }

    //Function for creating the secret code
    public static int[] obtainingSecretCode() {
        Random random = new Random();
        int[] arrayOfSecretNumber;
        int counter;
        int secretNumber = random.nextInt(6666);
        arrayOfSecretNumber = decompositionOfNumber(secretNumber);
        counter = checkArray(arrayOfSecretNumber);
        while (counter != 12) {
            secretNumber = random.nextInt(6666);
            arrayOfSecretNumber = decompositionOfNumber(secretNumber);
            counter = checkArray(arrayOfSecretNumber);
        }
        for (int i = 0; i < 4; i++) {
            if (arrayOfSecretNumber[i] > 6) {
                arrayOfSecretNumber[i] = random.nextInt(6);
                counter = checkArray(arrayOfSecretNumber);
                while (counter != 12) {
                    arrayOfSecretNumber[i] = random.nextInt(6);
                    counter = checkArray(arrayOfSecretNumber);
                }
            }
        }
        return arrayOfSecretNumber;
    }
    //Function The attempt to guess the number from the user
    public static void guessANumber(int[] secretNumber, int route) {
        Scanner scanner = new Scanner(System.in);
        int[] guessNumber = new int[4];
        int success = 0;
        if (route > 0) {
            for (int i = 1; i < 5; i++) {
                System.out.println(" Type in a digit " + i);
                int randomNumber = scanner.nextInt();
                while (randomNumber > 6 || randomNumber < 0) {
                    System.out.println("out of bound," + " Please try again");
                    randomNumber = scanner.nextInt();
                }
                guessNumber[i - 1] = randomNumber;

            }
            int counterTwo = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guessNumber[i] == guessNumber[j]) {
                        counterTwo++;
                        if (counterTwo > 4) {
                            System.out.println("The code has a digit that repeats itself\n" +
                                    "Therefore 2 opportunities decrease");
                            route = route - 2;
                            counterTwo = -7;
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (guessNumber[i] == secretNumber[j]) {
                        if (i == j) {
                            System.out.println("The number " + guessNumber[i] + " accurate guessing");
                            success++;
                        } else {
                            System.out.println("The number " + guessNumber[i] + " partial guess (correct number in wrong position)");
                        }
                    }
                }

            }
            if (success != 4) {
                route = route - 1;
                guessANumber(secretNumber, route);
            }
            if (route == 1) {
                System.out.println("Last Chance");
            }
            if (success == 4) {
                System.out.println("Congratulations! You were able to decipher the code\n" +
                        "Remaining guesses " + route);

            }
        } else {
            System.out.println(secretNumber + " Game over");
        }
    }
    //Choosing a guessing path
    public static int levelSortingRoute() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Select a difficulty level\n" +
                "1- 20 opportunities\n" +
                "2- 15 opportunities\n" +
                "3- 10 opportunities\n" +
                "4- Random number between 5-25 opportunities");
        int route = scanner.nextInt();
        while (route > 4 || route <= 0) {
            System.out.println("Not in options Select again");
            route = scanner.nextInt();
        }
        route = switch (route) {
            case 1 -> 20;
            case 2 -> 15;
            case 3 -> 10;
            default -> route;
        };
        if (route == 4) {
            route = random.nextInt(25);
            while (route < 5) {
                route = random.nextInt(25);
            }
        }
        return route;

    }
    //Check duplication in the array
    public static int checkArray(int[] arrayInt) {
        int counter = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            for (int j = 0; j < arrayInt.length; j++) {
                if (arrayInt[i] != arrayInt[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }
}