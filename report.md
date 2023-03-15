# Netflix - Project Report

## Introduction
As the 4th assignment of our "Advanced programing" course, we shall program a simple version of Netflix! A terminal based program to store usernames, passwords, a list of movies, TV shows, etc.<br>
As some bonus features:
 - I've made simple data files to store usernames, passwords, list of all the shows and whether someone has added a show to his/her watched/favorites list.<br>
- Searching through a file is done using *Regular Expressions* (also known as *regex*). A paragraph is dedicated to regex in the following.
- Input validation is done throughout the project to prevent data repeating. (A paragraph is dedicated in the following)
## Preprations
- *Java* as the programing language <br>
- The IDE of choice was *IntelliJ IDEA (community Edition)*<br>
- *GIT* as a system version control<br>
- *Gradle* as the build automation tool
## Overall approach (in a nutshell)
(All of the changes were made on a seperate git branch called *develop*)<br>
The program contains of 2 classes: `Main` and `NetflixServices`. All the services (file handlings, dealing with useres, showing ,menus, etc.) are dealt with by the `NetflixServices` class and in `Main`, an abject of `NetflixServices` is created to start the program.

## What's *Regular Expressions* or *regex*?
As mentioned earlier, regex is used to find strings in a file, but what is regex?<br>
To be honest, there are books on regex and how to use it, but here I've provided a simple and short definition:<br>
Let's provide a [wikipedia](https://en.wikipedia.org/wiki/Regular_expression) explanation first: *Regex is a sequence of characters that specifies a match pattern in text. Usually such patterns are used by string-searching algorithms for "find" or "find and replace" operations on strings, or for input validation<br>
The concept of regular expressions began when an American mathematician **formalized** the concept of a **regular language**.*<br>
So in short, regex is a method to identify words are phrases in a text which follow a specefic way of writting.<br>
You can check [here](https://regexr.com/) to do some experimenting with regex.<br>
Also, there are videos by [*Jadi*](https://www.aparat.com/v/4xwoz) both at his *Aparat* and *Youtube* channel.


## Input Validation
This part is done using regex, too. In fact, to test whether a given string is present in a text or not, I've used regex to search the text. This way it is possible to check if that piece of info already exists in the text or not to make future decisions. 

## Testing 
To test the program after coding all the parts, I made a user (Shayan) with a given password (123) and started using different menus and items to check if the code was working without errors
## Future design improvements
- Using *mySQL* to create a data base.
- Adding GUI for better user experience.




