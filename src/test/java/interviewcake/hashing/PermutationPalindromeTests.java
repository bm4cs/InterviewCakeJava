package interviewcake.hashing;

import net.bencode.interviewcake.hashing.PermutationPalindrome;
import org.junit.Assert;
import org.junit.Test;

public class PermutationPalindromeTests {

    @Test
    public void GivenUnscrambledPalindromePermutationWhenCheckedThenPermutationFound() {
        boolean found = PermutationPalindrome.check("civic");
        Assert.assertTrue(found);
    }

    @Test
    public void GivenUnscrambledInvalidPalindromeWhenCheckedThenNoPermutationFound() {
        boolean found = PermutationPalindrome.check("civil");
        Assert.assertFalse(found);
    }

    @Test
    public void GivenScrambledPalindromePermutationWhenCheckedThenPermutationFound() {
        boolean found = PermutationPalindrome.check("ivicc");
        Assert.assertTrue(found);
    }

    @Test
    public void GivenInvalidScrambledPalindromeWhenCheckedThenNoPermutationFound() {
        boolean found = PermutationPalindrome.check("livci");
        Assert.assertFalse(found);
    }
}
