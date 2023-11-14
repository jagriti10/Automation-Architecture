package test.web;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.SkipException;

import com.w2a.base.W2aCoreTest;

public class SampleTest extends W2aCoreTest {
    
	@Test
	public void PassTest() {
    	System.out.println("user dir" + System.getProperty("user.dir"));
    	log.info("This test will always fail because it expects Runtime Exception and we will not get any");
    }
    
    @Test(expectedExceptions=RuntimeException.class)
    public void FailTest() {
    	log.info("This test will always fail because it expects Runtime Exception and we will not get any");
    }
    
    @Test
    public void SkipTest() {
        throw new SkipException("This test will always skipped because it throws SkipException.");
    }
    
    private int i=0;
    @Test(successPercentage=60, invocationCount=5)
    public void PassFailTest() {
        i++;
        System.out.println("invocation count: " + i);
        if (i == 1 || i == 2) {
            Assert.assertEquals(i, 8);
        }
    }
}
