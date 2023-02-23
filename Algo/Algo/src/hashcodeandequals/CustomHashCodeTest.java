package hashcodeandequals;

import java.util.HashMap;
import java.util.HashSet;

public class CustomHashCodeTest {

    /**
     * Person class overrides the hashcode and equals methods and therefore the HashTable(HashSet & HashMap)
     * works expected; if the objects are same, it counts as one object only since the HashCode are same as per the
     * overridden HashCode() method in Person class. If HashCode() method is not override, Object class generates for it
     * and that hashcode will be unique, even though the objects are same, that will result into inaccurate reading and
     * writing Hash algorithms(HashSet, HashMap).
     * Set and Map do not allow duplicates. However, if these two methods are not overridden, they fail to store
     * unique values, instead, they store duplicates value of the same object.
     * EX -  map.put(new Person("person 1",30),"p1");
     *       map.put(new Person("person 1", 30),"p2");
     * Due to this, Map internally crates two different indexes even though the objects are equal
     * HashMap working : HashMap internally calls hash function to convert the passed key into a code(hashcode)
     *                  Once the unique code is created, it then put the values associated with that key(unique code)
     *                  into an Array bucket by using that unique code as array index.
     *                  When map.get(key) is invoked, it again converts the key into the unique(hashcode) and that
     *                  key will be searched into the array bucket as index to get the respective value.

     */
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();

        set.add(new Person("person 1",30));
        set.add(new Person("person 1", 30));

        System.out.println(set.size());

        HashMap<Person, String> map = new HashMap<>();

        Person p1 = new Person("person 1",30);
        Person p2 = new Person("person 2",30);

        map.put(p1,"p1");
        map.put(p2,"p2");

        System.out.println(map.size());
        System.out.println(map.get(p1));
    }
}
