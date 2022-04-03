package WordCheck;

import java.util.Locale;

public class PlanMinimum  {
    private String word;
    private String lowerWord;
    private String noVowel;

    public void Palindrome(String word) throws MyException{
        this.word = word;

        if (word.length()<5){
            MyException exception = new MyException("This word has less then 5 letters");
            throw exception;
        }else {
            String rWord = new StringBuilder(word).reverse().toString();
            if (word.equalsIgnoreCase(rWord)) {
                System.out.println("Це слово паліндром");
            } else {
                System.out.println("Це не слово паліндром");
            }

            lowerWord = word.toLowerCase(Locale.ROOT);

            String[] vowel = {"а", "е", "и", "і", "о", "у", "я", "ю", "є", "ї", "a", "e", "i", "o", "u", "y" };


            for (int i = vowel.length; i > 0; i--){

                if(lowerWord.indexOf(vowel[i-1])!=-1){

                    String vLetter = vowel[i-1];
                    noVowel = lowerWord.replace(vLetter, "-");
                    lowerWord = noVowel;
                }
            }

            System.out.println(noVowel);


        }
    }


}
