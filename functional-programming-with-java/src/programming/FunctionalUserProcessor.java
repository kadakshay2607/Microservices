package programming;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class User {
    private String name;
    private String email;
    private int age;
    private boolean isActive;

    public User(String name, String email, int age, boolean isActive) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isActive = isActive;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public boolean isActive() { return isActive; }

    @Override
    public String toString() {
        return name + " (" + age + ") - " + email + (isActive ? " [Active]" : " [Inactive]");
    }
}

public class FunctionalUserProcessor {

    public static void main(String[] args) {

        // Step 1: Create list of users
        List<User> users = Arrays.asList(
            new User("Alice", "alice@example.com", 22, true),
            new User("Bob", "bob@example.com", 17, true),
            new User("Charlie", "charlie@example.com", 25, false),
            new User("Diana", "diana@example.com", 19, true),
            new User("Eve", "eve@example.com", 30, true)
        );

        // Step 2: Predicate - filter active users over age 18
        Predicate<User> isAdultAndActive = user -> user.getAge() >= 18 && user.isActive();

        // Step 3: Function - extract email
        Function<User, String> toEmail = User::getEmail;

        // Step 4: Consumer - print emails
        Consumer<String> print = System.out::println;

        // Step 5: Process with Stream
        System.out.println("Active users over 18:");
        List<String> emails = users.stream()
            .filter(isAdultAndActive)         // Filter
            .map(toEmail)                     // Map to email
            .peek(print)                      // Print
            .collect(Collectors.toList());    // Collect to list

        // Step 6: Optional - get first user over 25
        Optional<User> userOver25 = users.stream()
            .filter(u -> u.getAge() > 25)
            .findFirst();

        userOver25.ifPresent(u -> System.out.println("\nFirst user over 25: " + u));

        // Step 7: Reduce - total age of active users
        int totalAge = users.stream()
            .filter(User::isActive)
            .map(User::getAge)
            .reduce(0, Integer::sum);

        System.out.println("\nTotal age of active users: " + totalAge);
    }
}

