
package java8fun;

import java.util.Objects;

public class Person implements Singer
{

        String name;
        Integer age;

        public Person(String name, Integer age)
        {
            this.name = name;
            this.age = age;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public Integer getAge()
        {
            return age;
        }

        public void setAge(Integer age)
        {
            this.age = age;
        }

    @Override
    public String sing() {
        return "There was an old lady who swallowed a fly, I don't know why she swallowed a fly. Perhaps she'll die";
    
    }
    
//    @Override
//    public String toString()
//    {
//        return name + " "  + age;
//    }

	// equality only determined by the same name here...
    @Override
    public boolean equals(Object obj)
    {
        if(!obj.getClass().getSimpleName().equals("Person"))
            return false;
        
        Person p2 = (Person)obj;
        return name.equals(p2.getName());
        
    }

	// netbeans generated hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
}
