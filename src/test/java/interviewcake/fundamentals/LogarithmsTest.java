package interviewcake.fundamentals;

import net.bencode.interviewcake.fundamentals.Logarithms;
import org.junit.Assert;
import org.junit.Test;

public class LogarithmsTest {

    @Test
    public void GivenAnOrderedArrayOfIntegersWhenBinarySearchedForAHitThenItsFoundInLog2nTime() {
        boolean r = Logarithms.binarySearch(7, new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 1337});
        Assert.assertTrue(r);
    }
}
