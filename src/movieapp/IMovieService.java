/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieapp;

/**
 *
 * @author ACER
 */
public interface IMovieService {
    
    public abstract String getTitle() ; 
    public abstract String getCast();
    public abstract String getCategory();
    public abstract String getReleaseDate();
    public abstract double getBudget();
    
}
