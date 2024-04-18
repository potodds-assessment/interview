package luxoft;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class interview {

    public static Collection<User> sortUniq(Collection<User> users) {
        List<User> uList = new ArrayList<>(users);
        Collections.sort(uList, Comparator.comparing(User::getLastName));

        Set<User> result = new TreeSet<>(Comparator.comparing(User::getLastName).thenComparing(User::getFirstName));
//        Set<User> result = new TreeSet<>((a,b)->b.firstName.compareTo(a.firstName));
        result.addAll(uList);
        return result;
    }

    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("John", "Smith", 15, List.of(Hobby.TENNIS, Hobby.FOOTBALL)),
                new User("Sam", "Adams", 30, List.of(Hobby.FOOTBALL)),
                new User("Cindy", "Williams", 40, List.of(Hobby.TENNIS)),
                new User("Allison", "Williams", 22, List.of(Hobby.TENNIS)),
                new User("Cindy", "Williams", 40, List.of(Hobby.TENNIS)),
                new User("Angelina", "Jolie", 80, List.of(Hobby.TENNIS, Hobby.FOOTBALL)))
                ;
        
        for(User u : userList) {
            System.out.println(u);
        }

        System.out.println("============================");

        for(User u : sortUniq(userList)) {
            System.out.println(u);
        }
        System.out.println("============================");

        System.out.println("Average=" + userList.stream().collect(Collectors.averagingInt(p->p.age)));
    }
}

class User {
    public String firstName;
    public String lastName;
    public int age;
    private Collection<Hobby> hobbies;

    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}

    public User(String fName, String lName, int age, Collection<Hobby> h) {
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.hobbies = h;
    }

    public String toString() {
        return firstName + "," + lastName + "," + age + "," + hobbies.toString();
    }
}

enum Hobby { TENNIS, FOOTBALL; }
