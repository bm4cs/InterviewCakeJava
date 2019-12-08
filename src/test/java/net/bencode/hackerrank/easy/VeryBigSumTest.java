package net.bencode.hackerrank.easy;

import net.bencode.hackerrank.easy.VeryBigSum;
import org.junit.Assert;
import org.junit.Test;

public class VeryBigSumTest {

    @Test
    public void GivenFiveHugeIntegersWhenSummedThenNoOverflowInResult() {
        long r = VeryBigSum.aVeryBigSum(new long[]{1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L});
        Assert.assertEquals(5000000015L, r);
    }
}
