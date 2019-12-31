package interviewcake.arraysandstrings;

import net.bencode.interviewcake.arraysandstrings.ReverseWordsInPlace;
import org.junit.Assert;
import org.junit.Test;

public class ReverseWordsInPlaceTests {

    @Test
    public void GivenTheWordHelloAsCharArrayWhenReversedInPlaceThenIsMutatedInReverseOrder() {

        // the eagle has landed
        char[] test = { 'l', 'a', 'n', 'd', 'e', 'd', ' ', 'h', 'a', 's', ' ', 'e', 'a', 'g', 'l', 'e', ' ', 't', 'h', 'e'};
        ReverseWordsInPlace.reverseWords(test);
        Assert.assertArrayEquals("the eagle has landed".toCharArray(), test);

    }


}
