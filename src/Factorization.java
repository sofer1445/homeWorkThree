import java.util.Scanner;

//Exe3
public class Factorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the number you want to break down into factors");
        int number = scanner.nextInt();
        int[] array = NumbersArray(number);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");

        }


    }

    public static int[] NumbersArray(int num) {
        int counter = 0;
        int[] arr = new int[num / 2];
        if (num == 1 || num <= 0) {
            System.out.println(num + "," + "The number obtained does not fall into several factors");
        }
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                arr[counter] = i;
                counter++;
                num = num / i;
                if (num == i) {
                    arr[counter] = num;
                    counter++;
                    break;
                }
            }
        }
        int[] arr2 = new int[counter];
        for (int j = 0; j < counter; j++) {
            arr2[j] = arr[j];
        }
        return arr2;
    }

}
