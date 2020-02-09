package interviewcake.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static net.bencode.interviewcake.greedy.Shuffle.shuffle;

public class ShuffleTests {

    @Test
    public void arrayHasOneZeroTest() {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }


}
