package net.bencode.hackerrank.easy;

import net.bencode.hackerrank.easy.CompareTheTriplets;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CompareTheTripletTest {

    @Test
    public void GivenBobWinsEverythingWhenComparedToAliceThenGetsThreePoints() {
        var r = CompareTheTriplets.compareTriplets(List.of(2, 3, 1), List.of(7, 7, 8)).toArray(new Integer[0]);
        Assert.assertArrayEquals(new Integer[]{0, 3}, r);
    }

    @Test
    public void GivenAliceWinsEverythingWhenComparedToBobThenGetsThreePoints() {
        var r = CompareTheTriplets.compareTriplets(List.of(7, 7, 7), List.of(3, 4, 2)).toArray(new Integer[0]);
        Assert.assertArrayEquals(new Integer[]{3, 0}, r);
    }

    @Test
    public void GivenBobAndAliceBothWinLoseAndTieOneResultEachWhenComparedThenAreEqual() {
        var r = CompareTheTriplets.compareTriplets(List.of(3, 2, 1), List.of(1, 2, 3)).toArray(new Integer[0]);
        Assert.assertArrayEquals(new Integer[]{1, 1}, r);
    }

    @Test
    public void GivenBobAndAliceTieInEverythingWhenComparedThenBothGetZero() {
        var r = CompareTheTriplets.compareTriplets(List.of(3, 2, 1), List.of(3, 2, 1)).toArray(new Integer[0]);
        Assert.assertArrayEquals(new Integer[]{0, 0}, r);
    }
}
