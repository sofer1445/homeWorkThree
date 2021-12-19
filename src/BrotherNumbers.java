public class BrotherNumbers {
    //Exe2
    public static void main(String[] args) {
        int[] firstArray = {11, 333, 65, 103, 25, 12};
        int[] secondArray = {2, 9, 6, 106, 983, 54, 379, 241, 61, 7};
        int index = arrayScheme(firstArray, secondArray);
        System.out.println(index);
    }

    //decomposing the number
    public static int sumOfNumbers(int num) {
        int sum = 0;
        if (num < 10) {
            return num;
        }
        while (num / 10 != 0) {
            sum = sum + num % 10;
            num = num / 10;
            if (num < 10) {
                sum = sum + num;
            }
        }
        return sum;
    }

    //Array scheme and test
    public static int arrayScheme(int[] arr, int[] arrTwo) {
        int result;
        int counter = 0;
        int[] arrThree = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result = sumOfNumbers(arr[i]);
            counter = 0;
            for (int j = 0; j < arrTwo.length; j++) {
                if (result == sumOfNumbers(arrTwo[j])) {
                    counter++;
                    arrThree[i] = counter;
                }
            }
        }
        int counterTwo = arr.length;
        int indexOne = arrThree[0];
        for (int z = 0; z < arrThree.length; z++) {
            if (indexOne < arrThree[z]) {
                indexOne = arrThree[z];
                counterTwo = z;
            }
        }
        return counterTwo;
    }
}
