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
public interface IMovieAppService {
    
    public abstract boolean registerUser(String email);
    public abstract List<Movie> searchMovies(String query);
    public abstract Movie viewMovieDetails(String title);
    public abstract boolean addFavorites(String email, String title);
    public abstract boolean removeFavorites(String email, String title);
    public abstract User viewPersonalDetailsAndFavorites(String email);   
    public abstract List<Movie> searchFavorites(String email, String query);
    
}