import java.io.*;
import java.util.*;

public class User {
    String name;
    List<Movie> watchedMovies;

    public User(String name) {
        this.name = name;
        this.watchedMovies = new ArrayList<>();
    }

    public void watchMovie(Movie movie) {
        watchedMovies.add(movie);
    }

    public List<Movie> getWatchedMovies() {
        return watchedMovies;
    }


    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(name + ".txt")) {
            for (Movie movie : watchedMovies) {
                writer.println(movie.title + ";" + movie.genre);
            }
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }


    public static User loadFromFile(String name, List<Movie> allMovies) {
        User user = new User(name);
        File file = new File(name + ".txt");

        if (!file.exists()) return user;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(";");
                if (parts.length == 2) {
                    String title = parts[0];
                    String genre = parts[1];
                    // Try to find matching movie from allMovies
                    for (Movie m : allMovies) {
                        if (m.title.equals(title) && m.genre.equals(genre)) {
                            user.watchMovie(m);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }

        return user;
    }
}
