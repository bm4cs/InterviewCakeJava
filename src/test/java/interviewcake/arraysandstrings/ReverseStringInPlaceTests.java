package interviewcake.arraysandstrings;

import net.bencode.interviewcake.arraysandstrings.ReverseStringInPlace;
import org.junit.Test;
import org.junit.Assert;

public class ReverseStringInPlaceTests {

    @Test
    public void GivenTheWordHelloAsCharArrayWhenReversedInPlaceThenIsMutatedInReverseOrder() {

        char[] test = { 'h', 'e', 'l', 'l', 'o' };
        ReverseStringInPlace.reverse(test);
        Assert.assertArrayEquals(new char[] { 'o', 'l', 'l', 'e', 'h' }, test);

    }

}
