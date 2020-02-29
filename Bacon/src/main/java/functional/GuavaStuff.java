package functional;

import java.util.Arrays;
import java.util.function.Predicate;

import static com.google.common.collect.MoreCollectors.onlyElement;

public class GuavaStuff
{
    public static Integer filterToSingleElement(Predicate<Integer> filter, Integer... nums)
    {
        // Filter a collection to one element using Guava Stream Collector
        // Throws exception when multiple values are returned
        return Arrays.stream(nums)
                .filter(filter)
                .map(Integer::valueOf)
                .collect(onlyElement());

    }
}
