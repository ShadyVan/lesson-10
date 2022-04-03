package WordCheck;

import java.text.BreakIterator;
import java.util.Locale;

public class PlanMaximum {
    private String text;
    private String oftenWord;


    public void NumberOfWords(String text){
        this.text = text;

        int count = 0;

        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == '-' || text.charAt(i) == ' '){
                count++;
            }
        }
        if (count > 0){
            System.out.println( "У цьому реченні " + (count + 1) + " слів");
        }else {
            System.out.println("Це не речення");
        }
    }

    public void NumberOfSentences(String text){
        this.text = text;

        int count = 0;

        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == '.'| text.charAt(i) == '?' | text.charAt(i) == '!'){
                count++;
            }
        }
        if (count > 0){
            System.out.println("В цьому тексті " + count + " речення");
        }else {
            System.out.println("");
        }

    }

    public void RepeatedWordInText(String text) {
        this.text = text;

        String words = text.replaceAll("[-+.^:,?]", "").toLowerCase(Locale.ROOT);
        String [] wordArray = words.split(" ");
        int rwc = 1;
        int mrw = 0;

        for (int i = 0; i < wordArray.length; i++){
            for (int j = i + 1; j < wordArray.length; j++){
                if(wordArray[i].equals(wordArray[j])){
                    rwc++;
                }
            }
            if(rwc >= mrw){
                mrw = rwc;
                oftenWord = wordArray[i];
            }
            rwc = 1;
        }

        System.out.println("Найчастіше вживається слово " + oftenWord);

    }

    public void RepeatedWordInSentence(String text){
        this.text = text;

        // Оце цей чудо метод!!!! BreakIterator

        BreakIterator iterator = BreakIterator.getSentenceInstance();
        iterator.setText(text);
        int start = iterator.first();
        for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {

            System.out.println(text.substring(start, end));

            String words = text.substring(start, end).replaceAll("[-+.^:,?]", "").toLowerCase(Locale.ROOT);
            String [] wordArray = words.split(" ");
            int rwc = 1;
            int mrw = 0;

            for (int i = 0; i < wordArray.length; i++){
                for (int j = i + 1; j < wordArray.length; j++){
                    if(wordArray[i].equals(wordArray[j])){
                        rwc++;
                    }
                }
                if(rwc >= mrw){
                    mrw = rwc;
                    oftenWord = wordArray[i];
                }
                rwc = 1;
            }

            System.out.println("Найчастіше у цьому реченні вживається слово " + oftenWord);

        }

    }

}
