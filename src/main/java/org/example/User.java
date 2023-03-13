package org.example;
import java.util.ArrayList;

import java.util.HashMap;

class User {
    /*
    * FUNCTION: the user should have a function to watch a show and add it to watch history.
    *  *** NOTE: All search functions in user are for searching in favorite shows ***
    */

    // remember to add password strongness with regex

    // arrayList to store all users
    ArrayList<UserStruct> userList = new ArrayList<UserStruct>();
//----------------------------------------------------------------------------------------------------------------------
// constructor: write data to use when starting the program
    public User() {
        UserStruct userStruct = new UserStruct("Shayan", "123");
        userList.add(userStruct);
    }
//----------------------------------------------------------------------------------------------------------------------
    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title in favorite shows  logic here
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre in favorite shows  logic here
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year in favorite shows logic here
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
    public void addToFavorites(TVShow show) {
        // Implement add to favorites logic here
// easy to do!
    }
//----------------------------------------------------------------------------------------------------------------------
    public void viewFavorites() {
        // Implement view favorites logic here
// easy to do
    }
//----------------------------------------------------------------------------------------------------------------------
    public ArrayList<TVShow> getRecommendations() {
        // Implement get recommendations logic here
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
}
