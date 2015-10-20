package predicates;

import java.util.function.Predicate;
import predicates.Predicates.Gender;
import predicates.Predicates.Person;


public class IsAdultFemale implements Predicate<Person>
{
    @Override
    public boolean test(Person person)
    {
        return person.getAge() >= 18 && person.getGender() == Gender.FEMALE;
    }
}
