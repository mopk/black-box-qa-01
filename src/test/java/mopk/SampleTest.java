/**
 * Created by Mopk
 * on 2014-06-29 01:14.
 */
package mopk;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void testTestingEnvironment() {
        Assert.assertTrue(true);
    }

    @Test
    public void testFailing() {
        Assert.assertTrue(false, "It's OK. Fail fails ^^");
    }

    @Test(enabled = false)
    public void testIgnoring() {
        // ...
    }
}