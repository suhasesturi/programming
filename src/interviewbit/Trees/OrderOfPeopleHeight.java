package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Comparator;

public class OrderOfPeopleHeight {
    static class Person {
        int height;
        int inFront;

        Person(int height, int inFront) {
            this.height = height;
            this.inFront = inFront;
        }
    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> inFronts) {
        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < heights.size(); i++) {
            persons.add(new Person(heights.get(i), inFronts.get(i)));
            result.add(-1);
        }
        persons.sort(Comparator.comparingInt(a -> a.height));

        for (int i = 0; i < result.size(); i++) {
            Person person = persons.get(i);
            int count = person.inFront;
            for (int j = 0; j < result.size(); j++) {
                if (count == 0 && result.get(j) == -1) {
                    result.set(j, person.height);
                    break;
                }
                else if (result.get(j) == -1) count = Math.max(0, count - 1);
            }
        }

        return result;
    }
}
