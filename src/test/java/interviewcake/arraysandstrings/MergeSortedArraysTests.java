package interviewcake.arraysandstrings;

import net.bencode.interviewcake.arraysandstrings.MergeSortedArrays;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortedArraysTests {

    @Test
    public void GivenTwoSortedIntegerArraysWhenMergedThenASingleNeatlySortedArrayIsGivenBack() {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
        int[] mergedArray = MergeSortedArrays.mergeArraysCombinationalLogic(myArray, alicesArray);

        Assert.assertEquals(myArray.length + alicesArray.length, mergedArray.length);
        Assert.assertArrayEquals(new int[] { 1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19 }, mergedArray);
    }

}
