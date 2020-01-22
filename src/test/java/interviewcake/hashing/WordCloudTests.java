package interviewcake.hashing;

import net.bencode.interviewcake.hashing.WordCloud;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WordCloudTests {


    @Test
    public void simpleSplitTest() {
        // ben here
        final String text = "I like cake!";
        final WordCloud.WordCloudData actual = new WordCloud.WordCloudData(text);
        List<String> wordList = actual.splitWords(text);
        assertEquals(3, wordList.size());
        assertEquals("I", wordList.get(0));
        assertEquals("like", wordList.get(1));
        assertEquals("cake", wordList.get(2));
    }

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("I", 1);
            put("like", 1);
            put("cake", 1);
        }};
        final WordCloud.WordCloudData actual = new WordCloud.WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("and", 1);
            put("pound", 1);
            put("for", 2);
            put("dessert", 1);
            put("Chocolate", 1);
            put("dinner", 1);
            put("cake", 2);
        }};
        final WordCloud.WordCloudData actual = new WordCloud.WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Strawberry", 1);
            put("short", 1);
            put("Yum", 1);
        }};
        final WordCloud.WordCloudData actual = new WordCloud.WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Dessert", 1);
            put("mille-feuille", 1);
        }};
        final WordCloud.WordCloudData actual = new WordCloud.WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("mmm", 2);
            put("decisions", 2);
        }};
        final WordCloud.WordCloudData actual = new WordCloud.WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("Bakery", 1);
            put("Cakes", 1);
            put("Allie's", 1);
            put("Sasha's", 1);
        }};
        final WordCloud.WordCloudData actual = new WordCloud.WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

}
