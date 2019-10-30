package CodeWars;

import java.util.Random;

public class Main {


  static   Random random = new Random();

        public static int[] randomArray() {
            int[] array = new int[10];
            boolean numberAlreadyExists;
            for (int i = 1; i < array.length;) {
                numberAlreadyExists = false;
                int newRandomValue = random.nextInt(100);
                for (int j = 0; j < i; j++) {
                    if (array[j] == newRandomValue) {
                        numberAlreadyExists = true;
                        break;
                    }
                }
                if (!numberAlreadyExists) {
                    array[i] = newRandomValue;
                    i++;
                }
            }
            return array;
        }


    public static void main(String[] args) {
	// write your code her
