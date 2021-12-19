import java.util.Scanner;

//Exe5
public class EncryptionMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type text");
        String text = scanner.nextLine();
        char[] resultText = findingTheMostCommonCharacter(text);
        System.out.println(resultText);
    }


    public static char[] findingTheMostCommonCharacter(String text) {
        char leading;
        char leadingTwo;
        int counter;
        char[] charArray = new char[text.length()];
        int[] arrayString = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            counter = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    counter++;
                    arrayString[i] = counter;
                    charArray[i] = text.charAt(i);

                }
            }
        }
        int index = maximumNumberSearchׂ(arrayString);
        leading = charArray[index];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == leading) {
                arrayString[i] = 0;
            }
        }
        index = maximumNumberSearchׂ(arrayString);
        leadingTwo = charArray[index];
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == leading) {
                charArray[i] = leadingTwo;
            }
            if (text.charAt(i) == leadingTwo) {
                charArray[i] = leading;
            }
        }

        return charArray;
    }

    public static int maximumNumberSearchׂ(int[] array) {
        int index = 0;
        int indexTwo = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[index]) {
                indexTwo = i;
                index = indexTwo;
            }
        }
        return index;
    }
}
