package WordCheck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {

        System.out.println("Введіть слово мінімум з 5 літер, або речення яке закічується крапкою");

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        PlanMinimum a = new PlanMinimum();
        a.Palindrome(word);

        PlanMaximum b = new PlanMaximum();
        b.NumberOfWords(word);
        b.NumberOfSentences(word);
        b.RepeatedWordInText(word);
        b.RepeatedWordInSentence(word);
    }
}
