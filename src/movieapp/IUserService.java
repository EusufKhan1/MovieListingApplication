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
public interface IUserService {
    
    public abstract String getEmail();
    public abstract List<Movie> getFavorites();
    public abstract void addFavorite(Movie movie);
    public abstract boolean removeFavorite(Movie movie);
}
