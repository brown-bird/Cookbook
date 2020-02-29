package functional;

import org.junit.jupiter.api.Test;

import static functional.GuavaStuff.filterToSingleElement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GuavaStuffTest
{

    @Test
    public void testOnlyElementWithMultipleValues()
    {
        //filter any value less than 2
        Integer actual = filterToSingleElement(val -> val < 2, 1, 2, 3, 4);

        assertEquals(1, actual);
    }

    @Test
    public void testOnlyElementThrowsException()
    {
        // filter any value less than 4. Should throw exception because multiple values pass the filter
        assertThrows(IllegalArgumentException.class,
                () -> filterToSingleElement(val -> val < 4,1, 2, 3, 4));
    }
}