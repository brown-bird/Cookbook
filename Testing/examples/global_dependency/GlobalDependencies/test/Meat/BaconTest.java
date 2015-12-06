package Meat;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaconTest
{
    
    TestableBacon bacon;
    
    public BaconTest()
    {
        // set the instance as the test subclass
        TestableBacon.setTestInstance(new TestBaconSub());
        bacon = TestableBacon.getInstance();
    }
    
    @After
    public void cleanup()
    {
        TestableBacon.resetInstance();
    }
    
    @Test
    public void doStuffWithNoNetworkOrDatabaseCalls()
    {
        String actual = bacon.makeNetworkCallsAndDoBaconRelatedDatabaseThings();
        assertThat(actual, is("I made no calls but still smell delicious!"));
    }

    // subclass for testing only which overrides
    // methods that we want to alter the behavior of.
    private static class TestBaconSub extends TestableBacon
    {
        public TestBaconSub()
        {
        }
        
        // override to prevent unwanted behavior
        @Override
        public String makeNetworkCallsAndDoBaconRelatedDatabaseThings()
        {
            return "I made no calls but still smell delicious!";
        }
    }
}
