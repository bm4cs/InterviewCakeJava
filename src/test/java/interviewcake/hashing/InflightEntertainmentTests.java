package interviewcake.hashing;

import org.junit.Assert;
import org.junit.Test;
import net.bencode.interviewcake.hashing.InflightEntertainment;

public class InflightEntertainmentTests {

    @Test
    public void GivenAnArrayOfMovieDurationTimesAndAnOverallFlightTimeWhenCheckedForTwoMoviesThatCanBeWatchedToCompletionThenAPairIsFound() {

        var found = InflightEntertainment.existsTwoMoviesEqualToFlightTime(120, new int[] { 32, 46, 19, 119, 74 }); // 74 + 46 = 120
        Assert.assertTrue(found);

    }
}
