/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;
import java.util.*;

/**
 *
 * @author ACER
 */
public class MovieApp implements IMovieAppService{

    protected Map<String, User> users;
    protected List<Movie> movies;

    public MovieApp() {
        this.users = new HashMap<>();
        this.movies = new ArrayList<>();
    }

    public boolean registerUser(String email) {
        if (!users.containsKey(email)) {
            users.put(email, new User(email));
            return true;
        }
        return false;
    }

    public List<Movie> searchMovies(String query) {
        List<Movie> results = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(query) ||
                movie.getCast().contains(query) ||
                movie.getCategory().equalsIgnoreCase(query)) {
                results.add(movie);
            }
        }
        results.sort((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
        return results;
    }

    public Movie viewMovieDetails(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public boolean addFavorites(String email, String title) {
        if (users.containsKey(email)) {
            Movie movie = viewMovieDetails(title);
            if (movie != null) {
                users.get(email).addFavorite(movie);
                return true;
            }
        }
        return false;
    }

    public boolean removeFavorites(String email, String title) {
        if (users.containsKey(email)) {
            Movie movie = viewMovieDetails(title);
            if (movie != null) {
                return users.get(email).removeFavorite(movie);
            }
        }
        return false;
    }

    public User viewPersonalDetailsAndFavorites(String email) {
        return users.get(email);
    }

    public List<Movie> searchFavorites(String email, String query) {
        List<Movie> favorites = new ArrayList<>();
        if (users.containsKey(email)) {
            for (Movie movie : users.get(email).getFavorites()) {
                if (movie.getTitle().equalsIgnoreCase(query)) {
                    favorites.add(movie);
                }
            }
        }
        return favorites;
    }
   
    
}
