//Exe1
public class NumberChanges {
    public static void main(String[] args) {
        //The program that searches in an array of numbers, a number alternates with the minimum amount
        int[] array = {67,101,107,230,111,11,21};
        int answer = arrayTest(array);
        System.out.println(answer);
    }

    public static boolean getNumber(int naturalNumber) {
        //Checking the number alternates
        if (naturalNumber > 0) {
            if (naturalNumber <= 10) {
                return true;
            } else {
                int rest = naturalNumber / 10;
                int restTwo = naturalNumber % 10;
                int sum = (rest + restTwo) % 2;
                if (sum == 1) {
                    return true;
                }
            }

        }
        return false;
    }

    public static int arrayTest(int[] array) {
        //Checking alternating numbers in an array
        int indexContent;
        int counter = 0;
        int sum;
        int max = 10;
        int minIndex = 0;
        int module;
        for (int i = 0; i < array.length; i++) {
            indexContent = array[i];
            boolean matchCheck = getNumber(indexContent);
            if (!matchCheck) {
                counter++;

            }
            if (counter == array.length-1) {
                return -1;
            } else if (matchCheck) {
                module = indexContent % 10;
                while (indexContent / 10 >= 10) {
                    indexContent = indexContent / 10;
                }
                sum = (indexContent / 10) + module;
                if (sum < max) {
                    max = sum;
                    minIndex = i;
                }
            }
        }
        return minIndex;

    }
}


