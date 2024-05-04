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
public class User implements IUserService{
     private String email;
     private List<Movie> favorites;
     
     public User(String email) {
        this.email = email;
        this.favorites = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public List<Movie> getFavorites() {
        return favorites;
    }

    public void addFavorite(Movie movie) {
        favorites.add(movie);
    }

    public boolean removeFavorite(Movie movie) {
        return favorites.remove(movie);
    }
}
