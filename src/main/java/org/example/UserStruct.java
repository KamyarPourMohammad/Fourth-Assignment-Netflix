package org.example;
import java.util.ArrayList;
//
public class UserStruct {
    String name;
    String password;
//ArrayList<String> faveList = new ArrayList<String>();

    public UserStruct(String name, String password) {
        this.name = name;
        this.password = password;
//this.faveList = faveList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public ArrayList<String> getFaveShows() {
//        return faveList;
//    }
//
//    public void setFaveShows(String movieName) {
//        this.faveList.add(movieName);
//    }
}
