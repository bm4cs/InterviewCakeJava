package interviewcake.arraysandstrings;

import net.bencode.interviewcake.arraysandstrings.CafeOrderChecker;
import org.junit.Assert;
import org.junit.Test;

public class CafeOrderCheckerTests {

    @Test
    public void GivenThreeListsOfTakeOutDineInAndOrdersServedWhenVerifiedTThenOrdersMadeFirstComeFirstServeIsTrue() {

        int[] takeOutOrders = new int[] { 1, 3, 5 };
        int[] dineInOrders = new int[] { 2, 4, 6 };
        int[] servedOrders = new int[] { 1, 2, 3, 5, 4, 6 };
//        int[] servedOrders = new int[] { 1, 2, 4, 6, 5, 3 };

        Assert.assertTrue(CafeOrderChecker.checkFifo(takeOutOrders, dineInOrders, servedOrders));
    }
}
