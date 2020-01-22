package net.bencode.interviewcake.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCloud {


    public static class WordCloudData {

        private Map<String, Integer> wordsToCounts = new HashMap<>();

        private void populateWordsToCounts(String inputString) {

            List<String> words = splitWords(inputString);

            for (String word : words) {
                addWordToHashMap(word);
            }
        }

        private void addWordToHashMap(String word) {

            // case 1: same case (already exists)
            if (wordsToCounts.containsKey(word)) {
                wordsToCounts.put(word, wordsToCounts.get(word) + 1);
            }
            // case 2: check for lower version (i.e. current word is upper)
            else if (wordsToCounts.containsKey(word.toLowerCase())) {
                int lowerCaseCount = wordsToCounts.get(word.toLowerCase());
                wordsToCounts.put(word.toLowerCase(), lowerCaseCount + 1);
            }
            // case 3: check for upper version (i.e. current word is lower)
            else if (wordsToCounts.containsKey(capitalise(word))) {
                int capitalisedCount = wordsToCounts.get(capitalise(word));
                wordsToCounts.put(word, capitalisedCount + 1);
                wordsToCounts.remove(capitalise(word));
            }
            // case 4: not in hash map
            else {
                wordsToCounts.put(word, 1);
            }
        }

        private String capitalise(String word) {
            char[] chars = word.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            return String.copyValueOf(chars);
        }

        public List<String> splitWords(String inputString) {
            List<String> wordList = new ArrayList<>();

            int currentWordStartIndex = 0;
            int currentWordLength = 0;


            for (int i = 0; i < inputString.length(); i++) {

                char c = inputString.charAt(i);

                if ((i != inputString.length() - 1) && (Character.isLetter(c) || (currentWordLength > 0 && c == '-') || (currentWordLength > 0 && c == '\''))) {
                    if (currentWordLength == 0) {
                        currentWordStartIndex = i;
                    }

                    currentWordLength++;
                }
                else if (currentWordLength > 0) {

                    if (i == inputString.length() - 1  && (Character.isLetter(c) || (c == '-') || c == '\'')) {
                        currentWordLength++;
                    }

                    // lift out word
                    String currentWord = inputString.substring(currentWordStartIndex, currentWordStartIndex + currentWordLength);
                    wordList.add(currentWord);

                    // setup for next word
                    currentWordLength = 0;
                }

            }

            return wordList;
        }

        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }

        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
    }
}
