import java.util.*;

public class MovieRecommender {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie("Inception", "Sci-Fi"));
        allMovies.add(new Movie("The Matrix", "Sci-Fi"));
        allMovies.add(new Movie("Titanic", "Romance"));
        allMovies.add(new Movie("The Notebook", "Romance"));
        allMovies.add(new Movie("John Wick", "Action"));
        allMovies.add(new Movie("Mad Max", "Action"));
        allMovies.add(new Movie("Shrek", "Comedy"));
        allMovies.add(new Movie("Finding Nemo", "Animation"));


        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        User user = User.loadFromFile(name, allMovies);
        System.out.println("Welcome, " + name + "!");


        System.out.println("Your watched movies:");
        for (Movie m : user.getWatchedMovies()) {
            System.out.println("- " + m);
        }


        System.out.println("\nAvailable movies:");
        for (int i = 0; i < allMovies.size(); i++) {
            System.out.println(i + ": " + allMovies.get(i));
        }


        System.out.print("\nEnter the numbers of the movies youve just watched (comma-separated, or blank to skip): ");
        String input = scanner.nextLine();
        if (!input.trim().isEmpty()) {
            String[] indices = input.split(",");
            for (String indexStr : indices) {
                int index = Integer.parseInt(indexStr.trim());
                if (index >= 0 && index < allMovies.size()) {
                    Movie movie = allMovies.get(index);
                    if (!user.getWatchedMovies().contains(movie)) {
                        user.watchMovie(movie);
                    }
                }
            }
        }

        // Save updated data
        user.saveToFile();

        // Recommend movies
        List<Movie> recommendations = recommendMovies(user, allMovies);
        System.out.println("\nRecommendations for " + user.name + ":");
        if (recommendations.isEmpty()) {
            System.out.println("No new recommendations right now. Try watching more movies!");
        } else {
            for (Movie m : recommendations) {
                System.out.println("- " + m);
            }
        }

        scanner.close();
    }

    public static List<Movie> recommendMovies(User user, List<Movie> allMovies) {
        Set<String> likedGenres = new HashSet<>();
        for (Movie m : user.getWatchedMovies()) {
            likedGenres.add(m.genre);
        }

        List<Movie> recommendations = new ArrayList<>();
        for (Movie m : allMovies) {
            if (!user.getWatchedMovies().contains(m) && likedGenres.contains(m.genre)) {
                recommendations.add(m);
            }
        }

        return recommendations;
    }
}
