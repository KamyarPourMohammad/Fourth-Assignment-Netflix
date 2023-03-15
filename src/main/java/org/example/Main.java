package org.example;
//
public class Main {
    public static void main(String[] args) {
//        NetflixService.createFile();
//        NetflixService.startMenu();
        NetflixService nService = new NetflixService();
        nService.createFile();
        nService.startMenu();
    }
}

