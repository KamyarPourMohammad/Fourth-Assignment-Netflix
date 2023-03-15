package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
//
class NetflixService {
//----------------------------------------------------------------------------------------------------------------------
    public  void addTvShow(){
        Scanner input = new Scanner(System.in);

        System.out.print("Show Name: ");
        String show = input.nextLine();

        String filePath = "inventory.txt"; // the path to the file you want to search in
        Path path = Paths.get(filePath);
        List<String> lines = null; // read all lines of the file into a list
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean alreadyExists = false;
        for (String line : lines) {
            if (line.matches(".*" + show + ".*")) {
                alreadyExists = true;
            }
        }
        if(!alreadyExists){
                System.out.print("Genre: ");
                String genre = input.nextLine();
                System.out.print("Year of production: ");
                String yearOfProd = input.nextLine();
                try {
                    FileWriter writer = new FileWriter("inventory.txt", true);
                    writer.append( show.toLowerCase() + "|" + genre.toLowerCase() + "|" + yearOfProd + "|" + "TvShow" + "\n");
                    writer.close();
                    System.out.println("\nShow added successfully.\n");
                }
                catch(IOException e){
                    e.printStackTrace();
                }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public  void addMovie(){
        Scanner input = new Scanner(System.in);

        System.out.print("Movie Name: ");
        String movie = input.nextLine();

        String filePath = "inventory.txt"; // the path to the file you want to search in
        Path path = Paths.get(filePath);
        List<String> lines = null; // read all lines of the file into a list
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean alreadyExists = false;
        for (String line : lines) {
            if (line.matches(".*" + movie + ".*")) {
                alreadyExists = true;
            }
        }
        if(!alreadyExists){
            System.out.print("Genre: ");
            String genre = input.nextLine();
            System.out.print("Year of production: ");
            String yearOfProd = input.nextLine();
            try {
                FileWriter writer = new FileWriter("inventory.txt", true);
                writer.append( movie.toLowerCase() + "|" + genre.toLowerCase() + "|" + yearOfProd + "|" + "Movie" + "\n");
                writer.close();
                System.out.println("\nMovie added successfully.\n");
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void logout() {
        System.out.println("\nYou have logged out of the system\n");
        pause();
        startMenu();
    }
//----------------------------------------------------------------------------------------------------------------------
    public void  search(int sw) { //1: search on title 2: search on genre 3: search on year
        String filePath = "inventory.txt";
        boolean found = false;
        BufferedReader reader = null;
        int index1, index2, index3;
        String title, genre, year, type;
        String key;
        Scanner input = new Scanner(System.in);

        switch (sw){
            case 1:
                System.out.print("\nSearch on title: ");
                break;
            case 2:
                System.out.print("\nSearch on genre: ");
                break;
            case 3:
                System.out.print("\nSearch on year: ");
                break;
        }
        key = input.nextLine().toLowerCase();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null) { // read until there is no line
                index1 = line.indexOf('|');
                index2 = line.indexOf('|', index1 + 1);
                index3 = line.indexOf('|', index2 + 1);

                title = line.substring(0, index1);
                genre = line.substring(index1 + 1, index2);

                year = line.substring(index2 + 1, index3);
                type = line.substring(index3 + 1);

                switch (sw){
                    case 1: // tile
                        if (title.toLowerCase().equals(key)){
                            System.out.println("Title: " + title);
                            System.out.println("Genre: " + genre);
                            System.out.println("Release year: " + year);
                            System.out.println("Type: " + type);
                            System.out.println("----------------------------------------\n");
                            found = true;
                        }
                        break;
                    case 2: // genre
                        if (genre.toLowerCase().equals(key)){
                            System.out.println("Title: " + title);
                            System.out.println("Genre: " + genre);
                            System.out.println("Release year: " + year);
                            System.out.println("Type: " + type);
                            System.out.println("----------------------------------------\n");
                            found = true;
                        }
                        break;
                    case 3: // release year
                        if (year.equals(key)){
                            System.out.println("Title: " + title);
                            System.out.println("Genre: " + genre);
                            System.out.println("Release year: " + year);
                            System.out.println("Type: " + type);
                            System.out.println("----------------------------------------\n");
                            found = true;
                        }
                        break;
                }
                line = reader.readLine();
            }
            if (!found){
                System.out.println("\nNo show found!\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void startMenu(){

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
    public void createFile(){
        String fileName1 = "userPassword.txt";
        String fileName2 = "watchedFave.txt";
        String fileName3 = "inventory.txt";

        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File file3 = new File(fileName3);

        try {
            if (file1.createNewFile()){} // if there is no userPassword file --> create one
            else {} // file exists

            if (file2.createNewFile()){}
            else {}

            if (file3.createNewFile()){}
            else {}

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void login() {
        boolean found = false;
        Scanner input = new Scanner(System.in);

        System.out.println("\nSign in as admin with user \"Admin\" and password \"12345\"");
        System.out.println("Sign in as with user \"Shayan\" and password \"123\"\n");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();

        if ( username.equals("Admin") && password.equals("12345")){
            System.out.println("\nYou Are Now Signed In As Admin.\n");
            adminMenu();
        }
        else {
            String filePath = "userPassword.txt"; // the path to the file you want to search in
            Path path = Paths.get(filePath);
            List<String> lines = null; // read all lines of the file into a list
            try {
                lines = Files.readAllLines(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (String line : lines) {
                if (line.matches(".*" + username + ".*") && (line.matches(".*" + password + ".*"))) {
                    found = true;
                }
            }

            if (found && (username != "") && (password != "")) {
                System.out.println("\nYou have successfully loegged in.\n");
                userMenu(username);
            } else {
                System.out.println("\nWrong user or password!\n");
                login();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void userMenu(String username){
        Scanner input = new Scanner(System.in);
        int menuItem;
        do {
            System.out.println("1: Search on title");
            System.out.println("2: Search on genre");
            System.out.println("3: Search on release year");
            System.out.println("4: Add to Favorites");
            System.out.println("5: My Favorites");
            System.out.println("6: Add to Watched");
            System.out.println("7: My Watched");
            System.out.println("0: Log out");

            menuItem = input.nextInt();

            switch (menuItem){
                case 0:
                    logout();
                    break;
                case 1:
                    search(1);
                    break;
                case 2:
                    search(2);
                    break;
                case 3:
                    search(3);
                    break;
                case 4:
                    add2FaveOrWatched(username, 1);
                    break;
                case 5:
                    showFaveOrWatched(username, 1);
                    break;
                case 6:
                    add2FaveOrWatched(username, 2);
                    break;
                case 7:
                    showFaveOrWatched(username, 2);
                    break;
            }
        }while(true);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void signUp(){
        Scanner input = new Scanner(System.in);

        System.out.print("Username (must be less than 30 characters): ");
        String username = input.nextLine();

        if (username.length() > 30){
            System.out.println("\nInput name contains more than 30 characters!\n");
            pause();
            signUp();
        }
        boolean alreadyExists = false;
        String filePath = "userPassword.txt"; // the path to the file you want to search in

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
    public void pause(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press enter to continue ...");
        input.nextLine(); // pause and wait for user input
    }
//----------------------------------------------------------------------------------------------------------------------
    public void adminMenu(){
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("1: Add TV Show");
            System.out.println("2: Add Movie");
            System.out.println("0: Log out");

            int menuItem;
            menuItem = input.nextInt();

            switch (menuItem){
                case 0:
                    logout();
                    break;
                case 1:
                    addTvShow();
                    break;
                case 2:
                    addMovie();
                    break;
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void add2FaveOrWatched(String username, int sw){ //1: fave    2: watch
        String state = null;
        String filePath =  "watchedFave.txt"; // the path to the file you want to search in
        Scanner input = new Scanner(System.in);
        System.out.print("Title to add: ");
        String title = input.nextLine();

        if (sw == 1){
            state = "favorite";
        }
        else {
            state ="watched";
        }

        if(! isTitleValid(title)){ //check if title exists
            System.out.println("Invalid title!");
            pause();
            userMenu(username);
        }
        else {
            // check if show already exists in file
            Path path = Paths.get(filePath);
            List<String> lines = null; // read all lines of the file into a list
            try {
                lines = Files.readAllLines(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (String line : lines) {
                if ( line.matches(".*" + title + "|" + state + ".*") ) {
                    System.out.println("\nShow has been added previously\n");
                    return;
                }
            }
            // if the show isn't already in the file
            try {
                FileWriter writer = new FileWriter("watchedFave.txt", true);
                writer.append( username + "|" + title.toLowerCase() + "|" + state + "\n");
                writer.close();
                System.out.println("\nShow added to " + state + " list  successfully.\n");
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public boolean isTitleValid(String title){

        String filePath = "inventory.txt"; // the path to the file you want to search in
        Path path = Paths.get(filePath);
        List<String> lines = null; // read all lines of the file into a list
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            if ( line.matches(".*" + title + ".*") ) {
                return true;
            }
        }
        return false;
    }
//----------------------------------------------------------------------------------------------------------------------
    public void showFaveOrWatched(String userName, int sw){ // 1: fave    2: watch
        String filePath = "watchedFave.txt";
        BufferedReader reader = null;
        int index1, index2;
        String title, state, uName;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            while (line != null ) { // read until there is no line
                if (!line.equals("")) {
                    index1 = line.indexOf('|');
                    index2 = line.indexOf('|', index1 + 1);

                    uName = line.substring(0, index1);
                    title = line.substring(index1 + 1, index2);
                    state = line.substring(index2 + 1);

                    switch (sw) {
                        case 1: // favorite
                            if (uName.equals(userName) && state.equals("favorite")) {
                                System.out.println("\nTitle: " + title);
                                System.out.println("\n----------------------------------------");
                            }
                            break;
                        case 2: // watch
                            if (uName.equals(userName) && state.equals("watched")) {
                                System.out.println("\nTitle: " + title);
                                System.out.println("\n----------------------------------------");
                            }
                            break;
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
}




