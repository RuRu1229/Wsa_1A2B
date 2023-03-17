import java.util.Random;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        String answer = generateAnswer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input 4 non repeating digits.");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.length() != 4) {
                System.out.println("You must input exactly 4 digits. Please try again.");
                continue;
            }
            if (exactMatch(answer, input)) {
                System.out.println("You win!");
                break;
            } else {

            }
        }
    }

    private static boolean exactMatch(String answer, String input) {
        return answer.equals(input);
    }

    private static String generateAnswer() {
        Random random = new Random();
        StringBuilder givenAnswer = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int givenInt = random.nextInt(0, 10);
            givenAnswer.append(givenInt);
        }
        return givenAnswer.toString();
    }
}