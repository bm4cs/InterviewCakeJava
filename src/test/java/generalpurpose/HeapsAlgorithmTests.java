package generalpurpose;

import org.junit.Test;

import static net.bencode.generalpurpose.HeapsAlgorithm.permutationsHeapsAlgo;
import static org.junit.Assert.assertEquals;

public class HeapsAlgorithmTests {

    @Test
    public void changeForOneDollarTest() {
        permutationsHeapsAlgo(new int[] {1, 2, 3}, 3);
    }

}
