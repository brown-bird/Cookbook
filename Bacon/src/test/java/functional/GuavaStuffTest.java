package functional;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Predicate;

import static functional.GuavaStuff.filterToSingleElement;
import static functional.GuavaStuff.filterToSingleOptionalElement;
import static org.junit.jupiter.api.Assertions.*;

class GuavaStuffTest
{

    @Test
    public void testOnlyElementWithMultipleValues()
    {
        //filter any value less than 2
        Integer actual = filterToSingleElement(intsLessThan(2), 1, 2, 3, 4);

        assertEquals(1, actual);
    }

    @Test
    public void testOnlyElementThrowsException()
    {
        // filter any value less than 4. Should throw exception because multiple values pass the filter
        assertThrows(IllegalArgumentException.class,
                () -> filterToSingleElement(intsLessThan(4),1, 2, 3, 4));
    }

    @Test
    public void testToOptional()
    {
        // toOptional can return an optional if you have one or no elements in a stream
        Optional<Integer> actual = filterToSingleOptionalElement(intsLessThan(2), 1, 2, 3, 4);
        assertEquals(1, actual.get());
    }

    @Test
    public void testToOptionalEmptyOptional()
    {
        //toOptional returns empty optional
        Optional<Integer> actual = filterToSingleOptionalElement(intsLessThan(0), 1, 2, 3 );
        assertTrue(actual.isEmpty());
    }

    private static Predicate<Integer> intsLessThan(Integer i)
    {
        return val -> val < i;
    }
}