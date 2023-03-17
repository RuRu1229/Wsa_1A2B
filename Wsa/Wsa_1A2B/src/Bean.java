import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bean {
    public static void main(String[] args) {
        //取得四個不重複的亂數答案
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i =0;i<4;i++){
            random.nextInt(numbers.add);
        }

    }
}
