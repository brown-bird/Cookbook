import com.google.common.collect.Lists;

import java.util.stream.IntStream;
import static com.google.common.collect.MoreCollectors.onlyElement;


public class HelloWorld
{
    public static void main(String[] args)
    {
        // Filter a collection to one element using Guava Stream Collector
        Integer one = Lists.<Integer>newArrayList(1, 2, 3, 4).stream()
                .filter( num -> num < 2)
                .map(Integer::valueOf)
                .collect(onlyElement());

        System.out.println(one);
    }
}
