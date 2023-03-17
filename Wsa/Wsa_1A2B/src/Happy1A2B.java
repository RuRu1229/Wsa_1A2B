import java.util.Random;
import java.util.Scanner;

public class Happy1A2B {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int random = randomRange(9999, 0);
        String answer = String.format("%04d", random);

        String guess;

        do {
            System.out.println("Guess what? >~<");
            guess = scanner.next();
            
            if (guess.length() != 4) {
                sout
            }

        }while(!guess.equals(answer));
    }

    public static int randomRange(int max, int min) {
        Random random = new Random();
        int rn = random.nextInt(max) % (max - min + 1) + min;
        return rn;
    }
}
