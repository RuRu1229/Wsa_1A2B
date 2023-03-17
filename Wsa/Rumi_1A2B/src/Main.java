import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Long.reverse;

public class Main {
    public static void main(String[] args) {
        int[] num = new int[4];
        int number, key = 0, a = 0, b = 0;
        String ultimatePassword = "";
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            number = random.nextInt(9) + 1;
            boolean isDuplicate = false;
            //過濾重複數字
            for (int j = 0; j < i; j++) {
                if (num[j] == number) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                num[i] = number;
            } else {
                i--; // 重新產生一個新的隨機數
            }
        }
        for (int i = 0; i < 4; i++) {
            ultimatePassword += num[i];
        }
        // System.out.println(ultimatePassword );
        char[] coda = ultimatePassword.toCharArray();
        while (key != 1) {
            System.out.println("input:");
            String input = scanner.next();
            if (input.length() > 4 || input.length() < 3) {
                System.out.println("只能輸入四位數!\n請重新輸入:");
                input = scanner.next();
            } else {
                boolean[] isDuplicate = new boolean[10]; // 用於標記數字是否已經出現過
                boolean hasDuplicate = false; // 是否有重複的數字
                for (int i = 0; i < input.length(); i++) {
                    int digit = Character.digit(input.charAt(i), 10);
                    if (isDuplicate[digit]) {
                        hasDuplicate = true;
                        break;
                    } else {
                        isDuplicate[digit] = true;
                    }
                }
                if (hasDuplicate) {
                    System.out.println("數字不能重複!\n請重新輸入:");
                } else {
                    char[] chars = new char[input.length()];
                    for (int i = 0; i < input.length(); i++) {
                        chars = input.toCharArray();
                    }
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (coda[i] == chars[j]) {
                                if (i == j) {
                                    a += 1;
                                } else {
                                    b += 1;
                                }
                            }
                        }
                    }
                    if (a == 4) {
                        System.out.println("猜對了! 是否繼續遊戲? (Y/N)");
                        String yn = scanner.next().toUpperCase();
                        while (!yn.equals("Y") && !yn.equals("N")) {
                            System.out.println("請輸入 Y 或 N");
                            yn = scanner.next().toUpperCase();
                        }
                        if (yn.equals("N")) {
                            System.out.println("感謝你的遊玩!");
                            key = 1;
                        }
                    } else {
                        System.out.println(a + "A" + b + "b");
                    }
                    a = 0;
                    b = 0;
                }
            }
        }
    }
}