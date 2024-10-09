package main.concatenatedstringhard;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        String[] duplicateWords = new String[words.length];

        for (int i = 0; i <= s.length() - wordLength; i++) {
            String currentSub = s.substring(i, i + wordLength);

            for (int j = 0; j < words.length; j++){
                if (words[j].equals(currentSub)) {
                    System.arraycopy(words, 0, duplicateWords, 0, words.length);
                    int wordCounter = 1;
                    duplicateWords[j] = "";
                    wordCounter = getWordCounter(s, words, i, wordLength, wordCounter, duplicateWords);
                    if (wordCounter == words.length) {
                        result.add(i);
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static int getWordCounter
            (String s, String[] words, int i, int wordLength, int wordCounter, String[] duplicateWords) {

        int beginSubstring;
        int endSubstring;
        int p = wordCounter;

        for (int k = 0; k < words.length; k++) {
            beginSubstring = i + wordLength * wordCounter;
            endSubstring = i + wordLength * (wordCounter + 1);

            if (beginSubstring > s.length() || endSubstring > s.length()) {break;}
            String currentLoopSub = s.substring(beginSubstring, endSubstring);

            if (currentLoopSub.equals(duplicateWords[k])) {
                wordCounter++;
                duplicateWords[k] = "";

            }
        }
        if (p < wordCounter) {
            wordCounter = getWordCounter(s, words, i, wordLength, wordCounter, duplicateWords);
        }
        return wordCounter;
    }

    public static void main(String[] args) {
        ConcatenatedString concatenatedString = new ConcatenatedString();

        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(concatenatedString.findSubstring(s, words));

        String  s1 = "wordgoodgoodgoodbestword";
        String[] words1 = {"word","good","best","word"};
        System.out.println(concatenatedString.findSubstring(s1, words1));

        String  s2 = "barfoofoobarthefoobarman";
        String[] words2 = {"bar","foo","the"};
        System.out.println(concatenatedString.findSubstring(s2, words2));

        String  s3 = "wordgoodgoodgoodbestword";
        String[] words3 = {"word","good","best","good"};
        System.out.println(concatenatedString.findSubstring(s3, words3));

        String  s4 = "a";
        String[] words4 = {"a"};
        System.out.println(concatenatedString.findSubstring(s4, words4));
    }
}