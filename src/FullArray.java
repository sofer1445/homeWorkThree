//Exe4
public class FullArray {
    public static void main(String[] args) {
        int[] mixArray = {11, 13, 8, 9, 10, 12};
        int[] fullArray = {23, 22, 21, 20, 19};
        int[] array = arraySort(mixArray);
        boolean answer = checkArray(array);
        System.out.println("Is the array with the unknown numbers a complete array? " + answer);
        boolean answerForSecondArray = arrayTestDescending(fullArray);
        System.out.println("Is the second array with the unknown numbers a complete array? " + answerForSecondArray);
    }

    public static int[] arraySort(int[] array) {
        int length = array.length;
        int collector;
        int collectorTwo;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (array[i] < array[j]) {
                    collector = array[j];
                    collectorTwo = array[i];
                    array[i] = collector;
                    array[j] = collectorTwo;
                }
            }
        }
        return array;
    }

    public static boolean checkArray(int[] arrayTested) {
        int length = arrayTested.length;
        length = length - 1;
        int counter = 0;
        for (int i = 0; i < arrayTested.length; i++) {
            if (arrayTested[length] - arrayTested[i] == length - i) {
                counter++;
                if (counter == length) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean arrayTestDescending(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] != (array[i+1] + 1)) {
                return false;
            }
        }
        return true;
    }
}