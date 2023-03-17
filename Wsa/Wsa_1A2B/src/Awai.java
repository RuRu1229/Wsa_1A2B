import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Awai {
    public static void main(String[] args) {
        Random random = new Random();
        var RamArray=new ArrayList<Integer>();
        while (RamArray.size()!=4)
        {
            var num=random.nextInt(10);
            if(!RamArray.contains(num)) RamArray.add(num);
        }
        var Answer=0;
        for(var i=0;i<RamArray.size();i++)
        {
            Answer+= RamArray.get(i);
            if(Answer<999) Answer*=10;
        }

        var scanner = new Scanner(System.in);
        int ACounter=0;
        int BCounter=0;
        while (ACounter!=4)
        {
            String Answerstr=String.format("%4d",Answer);
            String scanstr= Integer.toString(scanner.nextInt());

            for (var i=0;i<Answerstr.length();i++)
            {
                if(Answerstr.charAt(i)==scanstr.charAt(i)) ACounter++;
                else
                {
                    for (var j=0;j<Answerstr.length();j++)
                    {
                        if(i!=j)
                        {
                            if(Answerstr.charAt(i)==scanstr.charAt(j)) 
                            {
                                BCounter++;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("");
        }
    }


}
