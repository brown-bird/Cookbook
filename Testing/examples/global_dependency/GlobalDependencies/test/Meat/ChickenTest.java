package Meat;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChickenTest
{
    Chicken instance;

    @Test
    public void overrideSingletonWithSubclass()
    {
        System.out.println("overrideSingletonWithSubclass");
        
        Chicken.setTestInstance(new TestFriedChicken());
        instance = Chicken.getInstance();
        
        assertThat(instance.createSmell(), is("Fried Chicken Smells Delicious!"));
        assertThat(instance.bite(), is("Delicious!"));
    }
    
    @Test
    public void overrideSingletonWithMock()
    {
        System.out.println("overrideSingletonWithMock");
        
        Chicken mockBBQChicken = mock(Chicken.class);
        when(mockBBQChicken.createSmell()).thenReturn("Mmm mmm BBQ Chicken smells YUMMY!");
        
        Chicken.setTestInstance(mockBBQChicken);
        instance = Chicken.getInstance();
        
        assertThat(instance.createSmell(), is("Mmm mmm BBQ Chicken smells YUMMY!"));
       
        // Fails because we didn't mock the bite method!
        assertThat(instance.bite(), is("Delicious!"));
    }

    private static class TestFriedChicken extends Chicken
    {
        private TestFriedChicken()
        {
        }
        
        @Override
        public String createSmell()
        {
            return "Fried Chicken Smells Delicious!";
        }
    }
    
}
