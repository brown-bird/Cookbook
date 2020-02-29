package functional;

import com.google.common.collect.Lists;

import static com.google.common.collect.MoreCollectors.onlyElement;

public class GuavaStuff
{
    public static void runExamples()
    {
        filterToSingleElement();
        filterToSingleElementThrowsException();
    }

    private static void filterToSingleElement()
    {
        // Filter a collection to one element using Guava Stream Collector
        Integer one = Lists.<Integer>newArrayList(1, 2, 3, 4).stream()
                .filter( num -> num < 2)
                .map(Integer::valueOf)
                .collect(onlyElement());

        System.out.println(one);
    }

    private static void filterToSingleElementThrowsException()
    {
        // Filter a collection to one element using Guava Stream Collector
        Integer one = Lists.<Integer>newArrayList(1, 2, 3, 4).stream()
                .filter( num -> num < 3)
                .map(Integer::valueOf)
                .collect(onlyElement());

        System.out.println(one);

    }
}
