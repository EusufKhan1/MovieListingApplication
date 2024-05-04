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
public class MovieListingAppTest extends MovieApp{
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        MovieApp app = new MovieApp();        
       while(true){
           

           System.out.print("Press 1 For Registration User-\nPress 2 For Add Movies-\n"
                 + "Press 3 For Search Movie-\nPress 4 For Add Favorites-\nPress 5 For Remove Favorites-\n"
                 + "Press 6 For See Movie Details-\nPress 0 For Exist The Project-");
           int test=input.nextInt();
           if(test==0){
               break;
           }
           else if(test==1){
                // Registering a user
                System.out.print("Enter email for register with MovieApp:");
                String user ;
                user=sc.nextLine();
                app.registerUser(user);
           }
            else if(test==2){
                // Adding some movies to the database
                  String title;
                  String cast;
                  String category;
                  String releaseDate;
                  double budget;
                  System.out.print("How many movie if you wanna add for movie list:");
                  int num=input.nextInt();
                  for(int i=1;i<=num;i++){
                      System.out.print("Enter movie's title:");
                      title=sc.nextLine();
                      System.out.print("Enter movie's cast:");
                      cast=sc.nextLine();
                      System.out.print("Enter movie's category:");
                      category=sc.nextLine();
                      System.out.print("Enter movie's relase date:");
                      releaseDate=sc.nextLine();
                      System.out.print("Enter movie's budget:");
                      budget=input.nextDouble();
                      app.movies.add( new Movie(title,cast,category,releaseDate,budget));
                  }
           }
           else if (test == 3) {
               // Testing movie search by title
               System.out.print("Enter movie's title for search:");
               String mov=sc.nextLine();
               List<Movie> searchResults = app.searchMovies(mov);
               System.out.print("Search results for '"+mov+"' :");
               for (Movie movie : searchResults) {
               System.out.println(movie.getTitle());
             }

           }
            else if(test==4){
                // Testing adding a movie to favorites
                 System.out.print("Enter email:");
                 String userEmail=sc.nextLine();
                 if (!app.users.containsKey(userEmail)) {
                     System.out.println("Not valid email.");
                     continue;
                  }
                 System.out.println("Enter movie for adding favorites :");
                 String movies=sc.nextLine(); 
                 boolean isValid=app.addFavorites(userEmail, movies);
                 if(isValid==false){
                     System.out.println("Not availabe this movie");
                     continue;
                 }
                 System.out.println("Favorites for " + userEmail + ":");
                 User user = app.viewPersonalDetailsAndFavorites(userEmail);
                 for (Movie movie : user.getFavorites()) {
                     System.out.println(movie.getTitle());
                 }
           }
            else if(test==5){
               // Testing removing a movie from favorites
               System.out.print("Enter email:");
                 String userEmail=sc.nextLine();
                 if (!app.users.containsKey(userEmail)) {
                     System.out.println("Not valid email.");
                     continue;
                  }
               System.out.print("Enter movie for removing favorites:");         
               String movies=sc.nextLine();
               app.removeFavorites(userEmail,movies);
               System.out.println("Favorites for " + userEmail + " after removal:");
               User user = app.viewPersonalDetailsAndFavorites(userEmail);
               user = app.viewPersonalDetailsAndFavorites(userEmail);
               for (Movie movie : user.getFavorites()) {
                  System.out.println(movie.getTitle());
               }
           }
            else{
                //Testing movie details
                System.out.print("Enter movie's title for see details this movie:");
                String title=sc.nextLine();
                Movie movie=app.viewMovieDetails(title);
                System.out.println("Title :"+movie.getTitle()+" Cast:"+movie.getCast()+" Category:"+
                        movie.getCategory()+" Relase Date:"+movie.getReleaseDate()+" Budget:"+movie.getBudget()+" \n");
                
            }
          
       }
                
    }
    
}
