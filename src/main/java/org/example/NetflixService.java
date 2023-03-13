package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
//
class NetflixService {



//----------------------------------------------------------------------------------------------------------------------
    public void addTVShow(TVShow tvShow){
        // Implement add tv show logic here
    }
//----------------------------------------------------------------------------------------------------------------------
    public void addMovie(Movie movie){
        // Implement add movie logic here
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void logout() {
        System.out.println("\nYou have logged out of the system\n");
        pause();
        startMenu();
    }
//----------------------------------------------------------------------------------------------------------------------
    public ArrayList<TVShow> searchByTitle(String title) {
        // Implement search by title logic here
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
    public ArrayList<TVShow> searchByGenre(String genre) {
        // Implement search by genre logic here
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
    public ArrayList<TVShow> searchByReleaseYear(int year) {
        // Implement search by release year logic here
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void startMenu(){

        Scanner input = new Scanner(System.in);

        int item;

        do{
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("0. Exit");

            item = input.nextInt();

            switch (item){

                case 0:
                    System.exit(0);
                    break;

                case 1:
                    login();
                    break;

                case 2:
                    signUp();
                    startMenu();
                    break;
            }
        }while (true);
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void createFile(){
        String fileName1 = "userPassword.txt";
        String fileName2 = "userFave";
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);

        try {
            if (file1.createNewFile()){} // if there is no userPassword file --> create one
            else {} // file exists

            if (file2.createNewFile()){}
            else {}
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void login() {
        boolean found = false;
        Scanner input = new Scanner(System.in);

        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
// read from file; if there is a name and password : found = true ; else = false.
        String filePath = "/Users/shayanshahrabi/Documents/University/Semester2/AP/AP-homework/Assignment4/Fourth-Assignment-Netflix/userPassword.txt"; // the path to the file you want to search in
        Path path = Paths.get(filePath);
        List<String> lines = null; // read all lines of the file into a list
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            if ( line.matches(".*" + username + ".*") && (line.matches(".*" + password + ".*")) ) {
                found = true;
            }
        }

        if (found){
            userMenu();
        }
        else{
            System.out.println("\nWrong user or password!\n");
            login();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void userMenu(){
        Scanner input = new Scanner(System.in);
        int menuItem;
        do {
            System.out.println("1: TV Shows");
            System.out.println("2: Movies");
            System.out.println("3: My Favorite Shows");
            System.out.println("0: Log out");

            menuItem = input.nextInt();

            switch (menuItem){
                case 0:
                    logout();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }while(true);
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void signUp(){
        Scanner input = new Scanner(System.in);

        System.out.print("Username (must be less than 30 characters): ");
        String username = input.nextLine();

        if (username.length() > 30){
            System.out.println("\nInput name contains more than 30 characters!\n");
            pause();
            signUp();
        }
        boolean alreadyExists = false;
        String filePath = "/Users/shayanshahrabi/Documents/University/Semester2/AP/AP-homework/Assignment4/Fourth-Assignment-Netflix/userPassword.txt"; // the path to the file you want to search in

        Path path = Paths.get(filePath);
        List<String> lines = null; // read all lines of the file into a list
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : lines) {
            if (line.matches(".*" + username + ".*")) {
                alreadyExists = true;
            }
        }
        if (alreadyExists){
            System.out.println("\nUsername is taken! Pick another one...\n");
            signUp();
        }
        if (!alreadyExists) {
            System.out.print("Password: ");
            String password = input.nextLine();

            try {
                FileWriter writer = new FileWriter("userPassword.txt", true);
                writer.append( username + " " + password + "\n");
                writer.close();
                System.out.println("\nRecord added successfully.\n");
                pause();
                startMenu();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void pause(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press enter to continue ...");
        input.nextLine(); // pause and wait for user input
    }
//----------------------------------------------------------------------------------------------------------------------
}


