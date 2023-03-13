package org.example;
//
class Movie extends TVShow {

    int length; // in minutes
//----------------------------------------------------------------------------------------------------------------------
// class constructor
    public Movie(){
        duration = 1;
    }
//----------------------------------------------------------------------------------------------------------------------
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
